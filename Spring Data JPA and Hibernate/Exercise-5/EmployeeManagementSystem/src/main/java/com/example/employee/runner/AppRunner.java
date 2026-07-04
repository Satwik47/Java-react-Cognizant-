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
    public void run(String... args) throws Exception {
        repository.save(new Employee("Satwik", "IT", 60000));
        repository.save(new Employee("Rahul", "HR", 35000));
        repository.save(new Employee("Priya", "IT", 70000));
        repository.save(new Employee("Kiran", "Finance", 50000));
        repository.save(new Employee("Anjali", "IT", 80000));

        System.out.println("-----findByDepartment-----");
        repository.findByDepartment("IT").forEach(System.out::println);
        System.out.println();

        System.out.println("-----findBySalaryGreaterThan-----");
        repository.findBySalaryGreaterThan(50000).forEach(System.out::println);
        System.out.println();

        System.out.println("-----findByNameContaining-----");
        repository.findByNameContaining("a").forEach(System.out::println);
        System.out.println();

        System.out.println("-----@Query Department-----");
        repository.getDepartmentEmployees("HR").forEach(System.out::println);
        System.out.println();

        System.out.println("-----@Query Salary Between-----");
        repository.getEmployeesBetweenSalary(40000, 70000).forEach(System.out::println);
        System.out.println();

        System.out.println("-----Named Query Department-----");
        repository.namedDepartment("Finance").forEach(System.out::println);
        System.out.println();

        System.out.println("-----Named Query Salary-----");
        repository.namedSalary(60000).forEach(System.out::println);
    }
}
