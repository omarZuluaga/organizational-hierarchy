package com.example.empresa.infrastructure.repository;

import com.example.empresa.model.domain.SubDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubDepartmentRepository extends JpaRepository<SubDepartment, Long> {

    List<SubDepartment> findByDepartmentId(Long id);
}
