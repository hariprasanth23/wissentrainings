package com.bt.networkservice.configuration;

import com.bt.networkservice.model.NetworkUser;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.bt.networkservice.repository",
        entityManagerFactoryRef = "networkUserEntityManagerFactory")
public class NetworkUserDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.networkuser")
    public DataSourceProperties networkUserDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.networkuser.configuration")
    public DataSource networkUserDataSource(){
        return networkUserDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name="networkUserEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean networkUserEntityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(networkUserDataSource())
                .packages(NetworkUser.class)
                .build();
    }

    @Bean(name="networkUserTransactionManager")
    @Primary
    public PlatformTransactionManager networkUserTransactionManager(final @Qualifier("networkUserEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }

}
