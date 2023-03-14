package com.wissen.multipledatasources.datasourceconfiguration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class NetworkUserDatasourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.network.user")
    public DataSourceProperties networkUserDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "networkUserDataSource")
    public DataSource networkUserDataSource() {
        return networkUserDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
