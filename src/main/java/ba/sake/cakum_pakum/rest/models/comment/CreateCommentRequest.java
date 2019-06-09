package ba.sake.cakum_pakum.rest.models.comment;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCommentRequest {

    @NotBlank
    private String content;
}
