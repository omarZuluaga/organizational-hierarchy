package com.example.empresa.controller;

import com.example.empresa.model.domain.dto.CompanyDto;
import com.example.empresa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/save")
    public CompanyDto save(@RequestBody  CompanyDto company){
        return companyService.save(company);
    }

    @GetMapping(value = "/get")
    public List<CompanyDto> getAll(){
        return companyService.findAll();
    }

    @GetMapping(value = "/getById/{id}")
    public CompanyDto getById(@PathVariable  Long id){
        return companyService.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Long delete(@PathVariable Long id){
        return companyService.delete(id);
    }

    @PutMapping(value = "/update/{id}")
    public CompanyDto update(@RequestBody CompanyDto companyDto, @PathVariable Long id){
        return companyService.update(companyDto, id);
    }
}
