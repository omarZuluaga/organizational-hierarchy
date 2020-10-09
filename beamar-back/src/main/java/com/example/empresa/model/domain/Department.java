package com.example.empresa.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity{

    private String departmentName;
    private String managerName;
    private String managerPhone;
    private Date managerDateBirth;
    private Date managerDateEntry;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SubDepartment> subDepartments;
    @ManyToOne()
    private Company company;
    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Date getManagerDateBirth() {
        return managerDateBirth;
    }

    public void setManagerDateBirth(Date managerDateBirth) {
        this.managerDateBirth = managerDateBirth;
    }

    public Date getManagerDateEntry() {
        return managerDateEntry;
    }

    public void setManagerDateEntry(Date managerDateEntry) {
        this.managerDateEntry = managerDateEntry;
    }

    public List<SubDepartment> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<SubDepartment> subDepartments) {
        this.subDepartments = subDepartments;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
