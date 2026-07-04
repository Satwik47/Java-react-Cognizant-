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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.ems.dept.repo",
        entityManagerFactoryRef = "deptEntityManager",
        transactionManagerRef = "deptTransactionManager"
)
public class DeptDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.dept")
    public DataSourceProperties deptDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource deptDataSource() {
        return deptDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "deptEntityManager")
    public LocalContainerEntityManagerFactoryBean deptEntityManager(EntityManagerFactoryBuilder builder) {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "create");
        props.put("hibernate.show_sql", "true");

        return builder
                .dataSource(deptDataSource())
                .packages("com.example.ems.dept.domain")
                .persistenceUnit("deptPU")
                .properties(props)
                .build();
    }

    @Bean(name = "deptTransactionManager")
    public PlatformTransactionManager deptTransactionManager(@Qualifier("deptEntityManager") EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
