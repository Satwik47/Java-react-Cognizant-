package com.example.handson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.handson4.entity.Employee;
import com.example.handson4.service.EmployeeService;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeService employeeService;

    public DataLoader(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.addEmployee(new Employee("John", "Doe", "Engineering", 85000));
        employeeService.addEmployee(new Employee("Jane", "Smith", "Marketing", 72000));
        employeeService.addEmployee(new Employee("Alice", "Johnson", "HR", 68000));

        List<Employee> employees = employeeService.listAllEmployees();

        StringBuilder output = new StringBuilder();
        output.append("Employee records created by Spring Data JPA:\n");
        output.append("---------------------------------------\n");
        for (Employee employee : employees) {
            output.append(employee).append("\n");
        }

        Path outputPath = Path.of("output.txt");
        try {
            Files.writeString(outputPath, output.toString());
            System.out.println("Output written to " + outputPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to write output file: " + e.getMessage());
        }
    }
}
