package com.example.empresa.service;


import com.example.empresa.model.domain.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto save(DepartmentDto departmentDto);
    Long delete(Long id);
    List<DepartmentDto> findByCompanyIds(Long id);
    DepartmentDto update (DepartmentDto departmentDto, Long id);
}
