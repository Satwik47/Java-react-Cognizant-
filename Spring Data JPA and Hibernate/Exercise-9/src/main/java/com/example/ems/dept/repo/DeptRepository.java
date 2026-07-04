package com.example.ems.dept.repo;

import com.example.ems.dept.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Department, Long> {
}
