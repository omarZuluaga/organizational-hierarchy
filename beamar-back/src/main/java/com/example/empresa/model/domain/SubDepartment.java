package com.example.empresa.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "subdepartments")
public class SubDepartment extends BaseEntity{

    private String subDepartmentName;
    @ManyToOne()
    private Department department;

    public String getSubDepartmentName() {
        return subDepartmentName;
    }

    public void setSubDepartmentName(String subDepartmentName) {
        this.subDepartmentName = subDepartmentName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
