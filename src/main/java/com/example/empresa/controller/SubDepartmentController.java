package com.example.empresa.controller;

import com.example.empresa.model.domain.SubDepartment;
import com.example.empresa.model.domain.dto.SubDepartmentDto;
import com.example.empresa.service.SubDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subDepartment")
public class SubDepartmentController {

    @Autowired
    private SubDepartmentService subDepartmentService;

    @PostMapping(value = "/save")
    public SubDepartmentDto save(@RequestBody SubDepartmentDto subDepartment){
        return subDepartmentService.save(subDepartment);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Long delete( @PathVariable  Long id){
        return subDepartmentService.delete(id);
    }

    @GetMapping(value = "/getSubDepartment/{id}")
    public List<SubDepartmentDto> getSubDepartment(@PathVariable Long id){
        return subDepartmentService.findByDepartment(id);
    }

    @PutMapping(value = "/update/{id}")
    public SubDepartmentDto update(@RequestBody SubDepartmentDto subDepartmentDto, @PathVariable Long id){
        return subDepartmentService.update(subDepartmentDto, id);
    }
}
