package com.english.cimu.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author acloudtwei
 * @version 1.0
 * @date 2021/12/6 17:09
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        // 1.SWAGGER_2
        return new Docket(DocumentationType.SWAGGER_2)
                //进入swagger-ui的信息
                .apiInfo(apiInfo())
                .select()
                // 2.设置扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.english.cimu.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("Swagger2 构建 RESTful API")
                .description("oss project")
                .version("v1.0")
                .termsOfServiceUrl("acloudtwei@gmail.com")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
