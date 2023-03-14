package com.bt.networkservice.configuration;

import com.bt.networkservice.model.Network;
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
entityManagerFactoryRef = "networkEntityManagerFactory")
public class NetworkDataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.network")
    public DataSourceProperties networkDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.network.configuration")
    public DataSource networkDataSource(){
        return networkDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name="networkEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean networkEntityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(networkDataSource())
                .packages(Network.class)
                .build();
    }

    @Bean(name="networkTransactionManager")
    @Primary
    public PlatformTransactionManager networkTransactionManager(final @Qualifier("networkEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
