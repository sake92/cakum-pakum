package ba.sake.cakum_pakum.rest.models.comment;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCommentDto {

    @NotBlank
    private String content;
}
