package com.gome.o2m.swagger.config;

import com.gome.o2m.swagger.controller.BaseController;
import com.google.common.base.Predicate;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * @author wangpeng24
 * @date 2017/6/6 10:27
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "application.swagger")
@Data
public class SwaggerConfig {

    private String title;
    private String version;
    private String description;
    private String contact;
    private String license;
    private String licenseUrl;

    @Bean
    public Docket setDocket(){

        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                //添加排除controller
                if(declaringClass == BaseController.class){
                    return false;
                }
                //被注解的类
                if(declaringClass.isAnnotationPresent(RestController.class)){
                    return true;
                }
                //被注解的方法
                if (input.isAnnotatedWith(ResponseBody.class)){
                    return true;
                }
                return false;
            }
        };

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gome.o2m.swagger.controller"))
                .apis(predicate)
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(this.title)
                .version(this.version)
                .description(this.description)
                //.contact(new Contact("moben", "www.baidu.com", "306426541@qq.com"))
                .contact(this.contact)
                .license(this.license)
                .licenseUrl(this.licenseUrl)
                .build();
    }
}
