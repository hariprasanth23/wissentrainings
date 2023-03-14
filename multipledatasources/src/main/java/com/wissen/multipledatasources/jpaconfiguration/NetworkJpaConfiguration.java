package com.wissen.multipledatasources.jpaconfiguration;

import com.wissen.multipledatasources.Entity.Network;
import org.springframework.beans.factory.annotation.Qualifier;
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
import java.util.Objects;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = Network.class,
        entityManagerFactoryRef = "networkEntityManagerFactory",
        transactionManagerRef = "networkTransactionManager")
public class NetworkJpaConfiguration {

    @Bean(name = "networkEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean networkEntityManagerFactory(
            @Qualifier("networkDataSource")DataSource dataSource,
            EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(dataSource)
                .packages(Network.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager networkTransactionManager(
            @Qualifier("networkEntityManagerFactory") LocalContainerEntityManagerFactoryBean networkEntityManagerFactory){
        return new JpaTransactionManager(Objects.requireNonNull(networkEntityManagerFactory.getObject()));
    }


}
