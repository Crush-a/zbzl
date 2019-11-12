package com.zbzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * todo 作用描述
 *
 * @Auther: ZhaoEnYang
 * @Date: 2018/8/16
 * @since 1.0
 */
@SpringBootApplication
@RestController
public class DBApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(DBApplication.class, args);
    }

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
          .allowCredentials(true)
          .allowedHeaders("*")
          .allowedOrigins("*")
          .allowedMethods("*");


    }
}


