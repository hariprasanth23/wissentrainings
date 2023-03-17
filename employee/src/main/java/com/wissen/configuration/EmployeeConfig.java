package com.wissen.configuration;

import com.wissen.entity.employee.Employee;
import com.wissen.repository.employee.EmployeeRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "EmployeeEntityManagerFactory",
        basePackageClasses = EmployeeRepository.class,
        transactionManagerRef = "EmployeeTransactionManager"
)
public class EmployeeConfig {

    @Primary
    @Bean(name="EmployeeDatasource")
    @ConfigurationProperties(prefix = "spring.employee.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name="EmployeeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactoryBean(
            EntityManagerFactoryBuilder builder, @Qualifier("EmployeeDatasource") DataSource dataSource){

        return builder.dataSource(dataSource)
                .packages("com.wissen.entity.employee")
                .persistenceUnit("Employee").build();

    }

    @Primary
    @Bean(name = "EmployeeTransactionManager")
    public PlatformTransactionManager employeeTransactionManager(
            @Qualifier("EmployeeEntityManagerFactory")EntityManagerFactory entityManagerFactory){

        return new JpaTransactionManager(entityManagerFactory);
    }



}
