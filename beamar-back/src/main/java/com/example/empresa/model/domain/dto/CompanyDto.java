package com.example.empresa.model.domain.dto;

import com.example.empresa.model.domain.Department;

import java.util.List;

public class CompanyDto {
    private Long id;
    private String name;
    private String nit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
