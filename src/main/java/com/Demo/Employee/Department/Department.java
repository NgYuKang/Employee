package com.Demo.Employee.Department;

import com.Demo.Employee.Employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    private String departmentName;

    public Department(){}

    public Department(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Department(Integer departmentId, String departmentName) {
        setDepartmentId(departmentId);
        setDepartmentName(departmentName);
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }



}
