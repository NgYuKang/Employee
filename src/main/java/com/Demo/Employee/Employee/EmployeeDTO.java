package com.Demo.Employee.Employee;

public class EmployeeDTO {
    private String employeeName;
    private String employeePosition;
    private Integer departmentId;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeName, String employeePosition, Integer departmentId) {
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.departmentId = departmentId;
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
