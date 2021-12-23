package com.techgeeknext.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Profile("qa")
//@Profile({"dev","qa"}) //make it enable for multiple environments
//@Profile("!prod") // enable for all environment except Production environment
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("emp-api")
                .apiInfo(swaggerDocumentationDetails())
                .select()
                .paths(restApis())
                .build();
    }

    private Predicate<String> restApis() {
        return or(regex("/api/anonymous-user/.*")
				, regex("/api/home-page.*"));
    }

    private ApiInfo swaggerDocumentationDetails() {
        return new ApiInfoBuilder()
                .title("TechGeekNext Swagger API")
                .description("TechGeekNext - Swagger Profile Example")
                .version("1.0")
                .contact("TechGeekNext")
                .license("TechGeekNext Swagger Example License")
                .licenseUrl("contact@techgeeknext.com")
                .version("1.0")
                .build();
    }
}