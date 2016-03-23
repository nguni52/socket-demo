package za.co.expertism.model.builder;

import za.co.expertism.model.Event;
import za.co.expertism.model.Request;

/**
 * Created by nguni52 on 16/03/23.
 */
public class RequestBuilder {
    private String eventType;
    private Event event;

    public RequestBuilder(String eventType, Event event) {
        this.eventType = eventType;
        this.event = event;
    }

    public static Request buildARequest(int i) {
        String eventType = "Authentication";
        Event event = EventBuilder.buildAnEvent(i);
        return new RequestBuilder(eventType, event).build();
    }

    private Request build() {
        return new Request(eventType, event);
    }
}
