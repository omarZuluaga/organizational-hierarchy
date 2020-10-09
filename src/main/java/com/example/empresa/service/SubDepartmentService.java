package com.example.empresa.service;

import com.example.empresa.model.domain.dto.SubDepartmentDto;

import java.util.List;

public interface SubDepartmentService {
    SubDepartmentDto save(SubDepartmentDto subDepartmentDto);
    Long delete(Long id);
    List<SubDepartmentDto> findByDepartment(Long id);
    SubDepartmentDto update(SubDepartmentDto subDepartmentDto, Long id);
}
