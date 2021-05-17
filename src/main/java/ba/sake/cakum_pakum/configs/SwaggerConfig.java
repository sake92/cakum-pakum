package ba.sake.cakum_pakum.configs;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ba.sake.cakum_pakum.rest.BlogPostResource;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        var restPackageName = BlogPostResource.class.getPackage().getName();
        return GroupedOpenApi.builder().group("public").pathsToMatch("/**")
                .packagesToScan(restPackageName).build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        var info = new Info().title("CakumPakum API").version("v1");
        return new OpenAPI().addServersItem(new Server().url("/")).info(info);
    }
}
