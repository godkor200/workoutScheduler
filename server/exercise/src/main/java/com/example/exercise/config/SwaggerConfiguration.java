package com.example.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
     
     @Bean
     public Docket api() {
          return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                                                        .securityContexts(Arrays.asList(securityContext()))
                                                        .securitySchemes(Arrays.asList(apiKey()))
                                                        .select()
                                                        .apis(RequestHandlerSelectors.basePackage("com.example.exercise"))
                                                        .paths(PathSelectors.any())
                                                        .build();
     }
     
     private SecurityContext securityContext() {
          return SecurityContext.builder()
                                .securityReferences(defaultAuth())
                                .build();
          
     }
     
     private List<SecurityReference> defaultAuth() {
          AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
          AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
          authorizationScopes[0] = authorizationScope;
          return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
     }
     
     private ApiKey apiKey() {
          return new ApiKey("Authorization", "Authorization", "header");
     }
     
     private ApiInfo apiInfo() {
          return new ApiInfoBuilder().title("운동 어플 api")
                                     .description("운동 어플 api 문서")
                                     .version("1.0")
                                     .build();
     }
}
