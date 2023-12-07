package com.employee.management.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecurityScheme(
        name = "Authorization",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("codepen@gmail.com");
        contact.setName("CodePen");
        contact.setUrl("https://codepen.io/");

        Info info = new Info()
                .title("Course ERP")
                .version("1.0")
                .contact(contact)
                .description("This Api exposes endpoints to manage tutorials.")
                .termsOfService("https://codepen.io/");
        return  new OpenAPI().info(info).addSecurityItem(
                new SecurityRequirement().addList("Authorization")
        );
    }

}