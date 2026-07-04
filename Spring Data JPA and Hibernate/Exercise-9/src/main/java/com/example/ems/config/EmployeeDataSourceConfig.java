package com.example.ems.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.ems.employee.repo",
        entityManagerFactoryRef = "employeeEntityManager",
        transactionManagerRef = "employeeTransactionManager"
)
public class EmployeeDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.employee")
    public DataSourceProperties employeeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource employeeDataSource() {
        return employeeDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "employeeEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean employeeEntityManager(EntityManagerFactoryBuilder builder) {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.show_sql", "true");

        return builder
                .dataSource(employeeDataSource())
                .packages("com.example.ems.employee.domain")
                .persistenceUnit("employeePU")
                .properties(props)
                .build();
    }

    @Bean(name = "employeeTransactionManager")
    @Primary
    public PlatformTransactionManager employeeTransactionManager(@Qualifier("employeeEntityManager") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
