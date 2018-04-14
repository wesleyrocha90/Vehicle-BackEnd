package com.vehicle;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vehicle"))
                .paths(PathSelectors.regex("/vehicle*.*"))
                .build()
                .apiInfo(metaInfo());
    }
    
    public ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Vehicle CRUD", 
                "Rest API to manage vehicle", 
                "1.0", 
                "Terms of Service", 
                new Contact("WesleyRocha", "https://github.com/wesleyrocha90", "wesleyallanrocha@gmail.com"), 
                "Apache License Version 2.0", 
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
        return apiInfo;
    }
}
