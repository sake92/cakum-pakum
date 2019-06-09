package ba.sake.cakum_pakum.configs;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ba.sake.cakum_pakum.rest.BlogPostResource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.select().apis(basePackage(BlogPostResource.class.getPackage().getName()))
                .paths(PathSelectors.any()).build();

        return docket;
    }
}
