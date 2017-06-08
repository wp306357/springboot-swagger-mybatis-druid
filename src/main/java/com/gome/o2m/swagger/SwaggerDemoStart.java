package com.gome.o2m.swagger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author wangpeng24
 * @date 2017/6/5 15:46
 * @Copyright(c) gome inc Gome Co.,LTD
 */
/**
 * mapperScan注解:指定扫描mapper的包，注:自定义mapper(例:ReadMapper)不能被扫描到
 */
@MapperScan("com.gome.o2m.swagger.dao")
@SpringBootApplication
@ServletComponentScan(basePackages = "com.gome.o2m.swagger")
public class SwaggerDemoStart {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoStart.class, args);
    }

}
