package com.dsm.moi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("com.mysql.cj.jdbc.Driver")
    private String driverClassName;

    @Value("jdbc:mysql://moi-rds.cfc2yl6t4e27.ap-northeast-2.rds.amazonaws.com/moi?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC")
    private String url;

    @Value("admin")
    private String username;

    @Value("asdfjkl;")
    private String password;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName(driverClassName)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
}
