package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Query Method
    List<Employee> findByDepartment(String department);

    // Query Method
    List<Employee> findBySalaryGreaterThan(double salary);

    // Query Method
    List<Employee> findByNameContaining(String name);

    // @Query
    @Query("SELECT e FROM Employee e WHERE e.department=:dept")
    List<Employee> getDepartmentEmployees(@Param("dept") String dept);

    // @Query
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
    List<Employee> getEmployeesBetweenSalary(
            @Param("min") double min,
            @Param("max") double max);

    // Named Query
    @Query(name = "Employee.findByDepartment")
    List<Employee> namedDepartment(@Param("department") String department);

    // Named Query
    @Query(name = "Employee.findBySalaryGreaterThan")
    List<Employee> namedSalary(@Param("salary") double salary);
}
