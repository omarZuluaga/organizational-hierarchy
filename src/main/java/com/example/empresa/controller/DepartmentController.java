package com.example.empresa.controller;

import com.example.empresa.model.domain.dto.DepartmentDto;
import com.example.empresa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/save")
    public DepartmentDto save(@RequestBody DepartmentDto department){
        return departmentService.save(department);
    }

    @GetMapping(value = "/getDepartments/{id}")
    public List<DepartmentDto> getDepartments(@PathVariable  Long id){
        return departmentService.findByCompanyIds(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Long delete(@PathVariable Long id){
         return departmentService.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    public DepartmentDto update(@RequestBody  DepartmentDto departmentDto, @PathVariable  Long id){
        return departmentService.update(departmentDto, id);
    }
}
