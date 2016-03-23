package za.co.expertism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nguni52 on 16/03/23.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private String message;
    private boolean status;
}
