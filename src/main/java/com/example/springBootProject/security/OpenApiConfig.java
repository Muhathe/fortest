package com.example.springBootProject.security;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "test swagger",version = "v1",
        description = "Bu swagger test uchun qilingan",
        contact = @Contact(name = "sfera",url = "http://sferaacademy",email = "muhammadnazirqulov1@gmail.com"),
                license = @License(name = "apache foundation",url = "https://apache.org/")
),
security = {
                @SecurityRequirement(name = "Bearer")
}

)
@SecurityScheme(
        name = "Bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)

public class OpenApiConfig {

}
