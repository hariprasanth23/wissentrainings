package com.wissen.configuration;

import com.wissen.entity.Partner;
import com.wissen.repository.partner.PartnerRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "partnerEntityManagerFactory",
        basePackageClasses = PartnerRepository.class,
        transactionManagerRef = "partnerTransactionManager"
)
public class PartnerConfig {

    @Bean(name="partnerDatasource")
    @ConfigurationProperties(prefix = "spring.partner.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="partnerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("partnerDatasource") DataSource dataSource){

        return builder.dataSource(dataSource)
                .packages(Partner.class).build();

    }

    @Bean(name = "partnerTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("partnerEntityManagerFactory")EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }



}
