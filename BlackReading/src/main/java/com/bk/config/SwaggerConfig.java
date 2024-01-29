package com.bk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @Description: Swagger 文档工具,能够动态生成文档
 *  Swagger 的登录地址: http:/localhost:8383/swagger-ui/index.html#/
 * @author: BlackWarm
 * @date: 2023年 12月 24日  11:48
 */
@Configuration
@EnableOpenApi
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bk"))
                .paths(PathSelectors.any())
                .build()
                //swagger 授权配置
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private SecurityScheme securityScheme(){
        //return new ApiKey("Authorization","Authorization","header");
        return new ApiKey("X-Token","X-Token","header");
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(
                new SecurityReference("X-Token", authorizationScopes)
        );
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Black在线阅读平台接口文档")
                .description("Black在线阅读平台项目实战")
                .version("1.0")
                .contact(new Contact("BlackWarm2023","https://blackwarm2023.github.io/","BlackWarm2023@163.com"))
                .build();
    }
}
