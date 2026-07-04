package com.example.employeesystem.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeesystem.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findByNameContaining(String keyword);

    // Pagination
    Page<Employee> findAll(Pageable pageable);
}
