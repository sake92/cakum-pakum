package ba.sake.cakum_pakum.rest.models.blogpost;

import javax.validation.constraints.NotBlank;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Create model for blog post")
public class CreateBlogPostDto {

    @NotBlank
    @ApiModelProperty(example = "My first blog post")
    private String content;
}
