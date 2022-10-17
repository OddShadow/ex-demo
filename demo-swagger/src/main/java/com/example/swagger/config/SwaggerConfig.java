package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger-ui 地址 <a href="http://localhost:8080/swagger-ui/">http://localhost:8080/swagger-ui/</a><br/>
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.OAS_30)
                // 如果有多个docket实例，需要有唯一groupName
//                .groupName("")
                // 设置api的meta信息，包括在json ResourceListing响应中
                .apiInfo(apiInfo())
                //是否开启swagger，如果为false则Swagger在浏览器中无法访问
//                .enable(true)
                .select()
                //扫描该包下面的注解
//                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    // 配置 swagger 信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目演示接口文档")
//                .description("项目用来演示io.springfox:springfox-boot-starter:3.0.0的使用")
//                .termsOfServiceUrl("http://localhost:8080")
//                .contact(new Contact("Rick", "www.google.com", "rick@gmail.com"))
//                .license("Apache 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("1.0.0")
                .build();
    }

}
