package com.Demo.Employee.Project;

import com.Demo.Employee.Employee.Employee;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String projectName;


    @ManyToMany
    @JoinTable(
            name = "EmployeeProject",
            joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "employeeId")
    )
    private List<Employee> employees;


    public Project(){}

    public Project(Integer projectId, String projectName){
        super();
        setProjectId(projectId);
        setProjectName(projectName);
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}