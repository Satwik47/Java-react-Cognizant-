package com.example.employeesystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.employeesystem.entity.Employee;
import com.example.employeesystem.repository.EmployeeRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.save(new Employee("John", "john@example.com", "IT"));
            employeeRepository.save(new Employee("David", "david@example.com", "HR"));
            employeeRepository.save(new Employee("Alice", "alice@example.com", "Finance"));
            employeeRepository.save(new Employee("Robert", "robert@example.com", "IT"));
            employeeRepository.save(new Employee("Steve", "steve@example.com", "Sales"));
            employeeRepository.save(new Employee("Tom", "tom@example.com", "Marketing"));
        };
    }
}
