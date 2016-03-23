package za.co.expertism.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import za.co.expertism.model.Request;
import za.co.expertism.model.ResponseMessage;
import za.co.expertism.model.builder.RequestBuilder;
import za.co.expertism.service.RequestService;

/**
 * Created by nguni52 on 16/03/23.
 */
@Controller
public class RequestController {
    private Log log = LogFactory.getLog(RequestController.class);
    private static final String SUBSCRIBE = "subscribe";
    public static final String HOME_SUBSCRIBE = MainController.HOME + SUBSCRIBE;
    private static final String SEND = "send";
    public static final String HOME_SEND = MainController.HOME + SEND;

    @Autowired
    private RequestService requestService;

    /**
     * Handles websocket subscription event based on path /app/subscribe
     *
     * @return
     * @throws Exception
     */
    @SubscribeMapping(HOME_SUBSCRIBE)
    public ResponseMessage subscribe() throws Exception {
//        log.info("Doing the subscription \n\n\n\n");

        return new ResponseMessage("Subscribe successful", true);
    }

    /**
     * Handles the websocket request for send to path /app/send. Responds to users by allowing them to subscribe to the
     * path /user/queue/auth
     *
     * @param test - The message that we can send to the method.
     * @return - A reply message based on the processed request
     */
    @MessageMapping(HOME_SEND)
    @SendToUser("/queue/auth")
    public ResponseMessage send(@Payload String test) {
        Request request = RequestBuilder.buildARequest(1);
        return new ResponseMessage(requestService.sendMessage(request), true);
    }


    /**
     * Handle any errors that can result from subscription processing
     *
     * @param exception
     * @return
     */
    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
    }
}
