package com.zbzl.config;

import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 读取mybatis配置
 *
 * @Auther: ZhaoEnYang
 * @Date: 2018/8/13
 * @since 1.0
 */
@Component
public class LocalMybatisPropertiesLoader {
    @Bean("mybatisproperties")
    @ConfigurationProperties(prefix = "mybatis")
    @Primary
    public LocalMybatisProperties localMybatisProperties() {
        return new LocalMybatisProperties();
    }

    class LocalMybatisProperties extends MybatisProperties {
    }

}
