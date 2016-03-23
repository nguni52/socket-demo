package za.co.expertism.model.builder;

import za.co.expertism.model.Event;

/**
 * Created by nguni52 on 16/03/23.
 */
public class EventBuilder {
    private String userPin;
    private String deviceId;
    private String deviceSer;
    private String deviceVer;
    private String transType;

    public EventBuilder(String userPin, String deviceId, String deviceSer, String deviceVer, String transType) {
        this.userPin = userPin;
        this.deviceId = deviceId;
        this.deviceSer = deviceSer;
        this.deviceVer = deviceVer;
        this.transType = transType;
    }

    public static Event buildAnEvent(int i) {
        String userPin = i+"2345";
        String deviceId = i+"2345";
        String deviceSer = "ABCDE";
        String deviceVer = "ABCDE";;
        String transType = "Users";

        return new EventBuilder(userPin, deviceId, deviceSer, deviceVer, transType).build();
    }

    private Event build() {
        return new Event(userPin, deviceId, deviceSer, deviceVer, transType);
    }
}
