package com.zbzl.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 配置数据源，
 *
 * @Auther: ZhaoEnYang
 * @Date: 2018/8/13
 * @since 1.0
 */
@Configuration
public class LocalDatasourceAutoConfiguration {
    /**
     * 配置数据源
     *
     * @return
     */
    @Bean("datasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

}
