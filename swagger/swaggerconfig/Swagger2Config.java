package com.swagger.swaggerconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket swaggerConfig() {

        ApiInfo apiInfo = new ApiInfo("Students Detail", "Students management api description",
                "1.0", "https://www.javatpoint.com/", new Contact(
                "Javatpoint Website",
                "https://www.javatpoint.com/swagger",
                "mailid@gmail.com"
        ),
                "opensource", "http://localhost:8080/api/students",
                Collections.emptyList());

        Docket docket;
        docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .build()
                .apiInfo(apiInfo);

        return docket;
    }
}
