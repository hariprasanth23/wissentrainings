package com.wissen.multipledatasources.datasourceconfiguration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class NetworkDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.network")
    public DataSourceProperties networkDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "networkDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.network.hikari")
    public DataSource networkDataSource(){
        return networkDataSourceProperties().initializeDataSourceBuilder()
                .build();
    }
}
