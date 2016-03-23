package za.co.expertism.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Service;
import za.co.expertism.model.Request;
import za.co.expertism.util.XStreamTranslator;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by nguni52 on 16/03/23.
 */
@Service
public class RequestService {
    @Value("${connection.host}")
    private String host;
    @Value("${connection.port}")
    private String port;

    private final MessageSendingOperations<String> messagingTemplate;
    private AtomicBoolean brokerAvailable = new AtomicBoolean();
    private Log log = LogFactory.getLog(RequestService.class);

    @Autowired
    public RequestService(MessageSendingOperations<String> messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void onApplicationEvent(BrokerAvailabilityEvent event) {
        this.brokerAvailable.set(event.isBrokerAvailable());
    }

    public String sendMessage(Request request) {
        if (this.brokerAvailable.get()) {
            String url = host + ":" + port;
            String xml = XStreamTranslator.getInstance().toXMLString(request);
            xml.replaceAll("za.co.expertism.model.", "");
            xml.replaceAll("[\\n\\s\\t]+", "");
            log.info(xml);
//            this.messagingTemplate.convertAndSend(url, request);
        }

        return "reply";
    }
}
