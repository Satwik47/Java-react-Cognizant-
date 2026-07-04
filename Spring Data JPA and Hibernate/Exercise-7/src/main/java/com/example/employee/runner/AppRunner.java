package com.example.employee.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Component
public class AppRunner implements CommandLineRunner {

    private final EmployeeRepository repository;

    public AppRunner(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        Employee emp = new Employee("Satwik", "IT", 65000);
        repository.save(emp);
        repository.findAll().forEach(System.out::println);
    }
}
