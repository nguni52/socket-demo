package za.co.expertism.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.expertism.SocketDemoApplicationTests;
import za.co.expertism.model.Request;
import za.co.expertism.model.builder.RequestBuilder;

/**
 * Created by nguni52 on 16/03/23.
 */
public class RequestServiceTest extends SocketDemoApplicationTests {
    private Request request;

    @Autowired
    private RequestService requestService;
    private Log log = LogFactory.getLog(RequestServiceTest.class);

    @Before
    public void setUp() {
        request = RequestBuilder.buildARequest(1);
    }

    @Test
    public void testSend() {
        String reply = requestService.sendMessage(request);
        log.info(reply);
    }
}
