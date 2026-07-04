package com.example.demo;

import com.example.demo.projections.EmployeeNameProjection;
import com.example.demo.projections.EmployeeWithDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<EmployeeNameProjection> findAllProjectedBy();
    List<EmployeeNameProjection> findBySalaryGreaterThan(Double salary);

    @Query("select e from Employee e")
    List<EmployeeWithDeptProjection> findAllWithDepartment();
}
