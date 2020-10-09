package com.example.empresa.service;

import com.example.empresa.model.domain.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto save(CompanyDto companyDto);
    List<CompanyDto> findAll();
    CompanyDto findById(Long id);
    Long delete(Long id);
    CompanyDto update(CompanyDto companyDto, Long id);
}
