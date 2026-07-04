package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmployeeProjectionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProjectionsApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(DepartmentRepository deptRepo, EmployeeRepository empRepo) {
        return args -> {
            Department hr = new Department(null, "Human Resources");
            Department eng = new Department(null, "Engineering");
            deptRepo.saveAll(List.of(hr, eng));

            empRepo.save(new Employee(null, "Alice", "Smith", "alice@example.com", 75000.0, hr));
            empRepo.save(new Employee(null, "Bob", "Johnson", "bob@example.com", 55000.0, eng));
            empRepo.save(new Employee(null, "Carol", "Davis", "carol@example.com", 82000.0, eng));

            System.out.println("--- Interface-based projection: EmployeeNameProjection (all employees) ---");
            List<EmployeeNameProjection> names = empRepo.findAllProjectedBy();
            names.forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName()));

            System.out.println("\n--- Projection: employees with salary > 60000 ---");
            List<EmployeeNameProjection> highEarners = empRepo.findBySalaryGreaterThan(60000.0);
            highEarners.forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName()));

            System.out.println("\n--- Projection with nested department: EmployeeWithDeptProjection ---");
            List<EmployeeWithDeptProjection> withDept = empRepo.findAllWithDepartment();
            withDept.forEach(p -> System.out.println(p.getFirstName() + " -> " + p.getDepartment().getName()));
        };
    }
}
