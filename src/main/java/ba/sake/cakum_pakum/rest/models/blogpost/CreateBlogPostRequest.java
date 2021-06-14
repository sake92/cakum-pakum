package ba.sake.cakum_pakum.rest.models.blogpost;

import javax.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Create model for blog post")
@Data
public class CreateBlogPostRequest {

    @Schema(example = "My first blog post")
    @NotBlank
    private String content;
}
