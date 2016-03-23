package za.co.expertism.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by nguni52 on 16/03/23.
 */
@Data
@AllArgsConstructor
public class Request {
    private String EventType;
    private Event Event;
}
