package com.example.empresa.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "departmentName")
    private String departmentName;
    @Column(name = "managerName")
    private String managerName;
    @Column(name = "managerPhone")
    private String managerPhone;
    @Column(name = "managerDateBirth")
    private Date managerDateBirth;
    @Column(name = "managerDateEntry")
    private Date managerDateEntry;
    private Long idPadre;
    @ManyToOne()
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /*public List<Department> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(List<Department> subDepartments) {
        this.subDepartments = subDepartments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }*/

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }
}
