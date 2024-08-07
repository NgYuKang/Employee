package com.Demo.Employee.Employee;


import com.Demo.Employee.Department.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private String employeePosition;

    @ManyToOne(optional = false)
    @JoinColumn(name="departmentId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    public Employee(){}

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }


    public Employee(Integer employeeId, String employeeName, String employeePosition, Department department) {
        setEmployeeId(employeeId);
        setEmployeeName(employeeName);
        setEmployeePosition(employeePosition);
        setDepartment(department);
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
