package com.example.ems;

import com.example.ems.dept.repo.DeptRepository;
import com.example.ems.employee.repo.EmployeeRepository;
import com.example.ems.dept.domain.Department;
import com.example.ems.employee.domain.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeRepository employeeRepository, DeptRepository deptRepository) {
        return args -> {
            employeeRepository.save(new Employee(null, "Alice"));
            deptRepository.save(new Department(null, "Finance"));

            long ecount = employeeRepository.count();
            long dcount = deptRepository.count();

            System.out.println("Employee count: " + ecount);
            System.out.println("Department count: " + dcount);
        };
    }
}
