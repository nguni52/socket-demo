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
    private Log log = LogFactory.getLog(RequestService.class);
    @Value("${connection.host}")
    private String host;
    @Value("${connection.port}")
    private String port;
    private final MessageSendingOperations<String> messagingTemplate;

    @Autowired
    public RequestService(MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * This method receives the request object, processes it to produce xml, and then sends the xml payload to the
     * remote server.
     *
     * @param request - object with user details for authorization request
     * @return - message to return once user has successfully send message
     */
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
