package ba.sake.cakum_pakum.rest.models.blogpost;

import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Create model for blog post")
public class CreateBlogPostRequest {

    @NotBlank
    @Schema(example = "My first blog post")
    private String content;
}
