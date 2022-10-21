package br.com.swaggers.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
/*
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
*/
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {                                    
    @Bean
    Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()   
          .apis(RequestHandlerSelectors.basePackage("br.com.swaggers.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaData())                .securityContexts(Arrays.asList(getSecurityContext()))
          .securitySchemes(Arrays.asList(basicAuthScheme()));

}

private SecurityScheme basicAuthScheme() {
  return new BasicAuth("basicAuth");
}

private SecurityContext getSecurityContext() {
  return SecurityContext.builder()
          .securityReferences(Arrays.asList(basicAuthReference()))
          .build();
}

private SecurityReference basicAuthReference() {
  return new SecurityReference("basicAuth", new AuthorizationScope[0]);
}

private ApiInfo metaData() {
  return new ApiInfoBuilder()
          .title("Parking REST API")
          .description("Spring Boot REST API for Parking")
          .version("1.0.0")
          .license("Apache License Version 2.0")
          .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
          .build();
}

}