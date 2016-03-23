package za.co.expertism.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import za.co.expertism.SocketDemoApplicationTests;
import za.co.expertism.model.Request;
import za.co.expertism.model.builder.RequestBuilder;

import static org.junit.Assert.assertEquals;

/**
 * Created by nguni52 on 16/03/23.
 */
public class XStreamTranslatorTest extends SocketDemoApplicationTests {
    private Request request;
    private XStreamTranslator xStreamTranslatorInst;
    private static Log log = LogFactory.getLog(XStreamTranslatorTest.class);

    @Before
    public void setUp() {
        request = RequestBuilder.buildARequest(1);
        xStreamTranslatorInst = XStreamTranslator.getInstance();
    }

    @Test
    public void simpleObjectToXMLStringVerifyTest() {
        String xml = xStreamTranslatorInst.toXMLString(request);

        String expected = getExpectedStringOutput();
        log.info(xml.replaceAll("[\\n\\s\\t]+", ""));
        log.info(xml.replaceAll("za.co.expertism.model.", ""));
        log.info(expected.replaceAll("za.co.expertism.model.", ""));
        assertEquals(expected, xml.replaceAll("[\\n\\s\\t]+", ""));
    }

    private String getExpectedStringOutput() {
        return "<za.co.expertism.model.Request><EventType>Authentication</EventType><Event><UserPin>12345</UserPin>" +
                "<DeviceId>12345</DeviceId><DeviceSer>ABCDE</DeviceSer><DeviceVer>ABCDE</DeviceVer><TransType>Users</TransType>" +
                "</Event></za.co.expertism.model.Request>";
    }
}
