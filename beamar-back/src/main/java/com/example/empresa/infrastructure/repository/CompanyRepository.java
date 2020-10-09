package com.example.empresa.infrastructure.repository;

import com.example.empresa.model.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
