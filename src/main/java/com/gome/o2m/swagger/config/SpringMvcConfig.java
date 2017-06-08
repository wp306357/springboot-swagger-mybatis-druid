package com.gome.o2m.swagger.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springMVC静态资源申明
 * @author wangpeng24
 * @date 2017/6/6 11:33
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/druid/**").addResourceLocations("classpath:/support/");
    }
}
