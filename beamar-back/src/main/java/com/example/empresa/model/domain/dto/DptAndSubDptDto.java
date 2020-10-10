package com.example.empresa.model.domain.dto;

import com.example.empresa.model.domain.Department;

import java.util.List;

public class DptAndSubDptDto {

    private int nivel;
    private String departmentName;
    private List<String> subDepartments;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<String> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<String> subDepartments) {
        this.subDepartments = subDepartments;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
