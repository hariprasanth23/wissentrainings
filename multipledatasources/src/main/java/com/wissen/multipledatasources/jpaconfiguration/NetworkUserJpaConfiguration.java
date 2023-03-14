package com.wissen.multipledatasources.jpaconfiguration;

import com.wissen.multipledatasources.Entity.NetworkUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackageClasses = NetworkUser.class,
        entityManagerFactoryRef = "networkUserEntityManagerFactory",
        transactionManagerRef = "networkUserTransactionManager"
)
public class NetworkUserJpaConfiguration {

    @Bean(name = "networkUserEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean networkUserEntityManagerFactory(
            @Qualifier("networkUserDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource)
                .packages(NetworkUser.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager networkUserTransactionManager(
            @Qualifier("networkUserEntityManagerFactory") LocalContainerEntityManagerFactoryBean networkUserEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(networkUserEntityManagerFactory.getObject()));
    }

}
