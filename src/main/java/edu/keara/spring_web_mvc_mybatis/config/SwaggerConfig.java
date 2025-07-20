package edu.keara.spring_web_mvc_mybatis.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("it.radom@gmail.com");
        contact.setName("KHOEM radom");
        contact.setUrl("https://www.radom.co");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Online Store API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to .").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList("Bearer Authentication")
                )
                .info(info);
    }
}
