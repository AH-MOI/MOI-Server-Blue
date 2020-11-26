package com.dsm.moi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    private final static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://moi-rds.cfc2yl6t4e27.ap-northeast-2.rds.amazonaws.com/moi?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "asdfjkl;";

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName(DRIVER_CLASS_NAME)
                .url(URL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
    }
}
