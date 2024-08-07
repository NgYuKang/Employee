package com.Demo.Employee.Project.DTO;

public class AddEmployeeDto {
    private Integer employeeId;

    public AddEmployeeDto() {
    }

    public AddEmployeeDto(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
