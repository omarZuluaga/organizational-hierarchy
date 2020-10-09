package com.example.empresa.infrastructure.repository;

import com.example.empresa.model.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByCompanyId(Long id);
}
