package ba.sake.cakum_pakum.dto.error;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ErrorMessageDto {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private String debugMessage;
}
