package za.co.expertism.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;
import za.co.expertism.model.Request;
import za.co.expertism.util.XStreamTranslator;

/**
 * Created by nguni52 on 16/03/23.
 */
@Service
public class RequestService {
    private final MessageSendingOperations<String> messagingTemplate;
    @Value("${connection.host}")
    private String host;
    @Value("${connection.port}")
    private String port;
    private Log log = LogFactory.getLog(RequestService.class);

    @Autowired
    public RequestService(MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public String sendMessage(Request request) {
        String url = host + ":" + port;
        String xml = XStreamTranslator.getInstance().toXMLString(request);
        xml.replaceAll("za.co.expertism.model.", "");
        xml.replaceAll("[\\n\\s\\t]+", "");
//        log.info(xml);
//        log.info(url);
        this.messagingTemplate.convertAndSend(url, request);

        return "SUCCESS";
    }
}
