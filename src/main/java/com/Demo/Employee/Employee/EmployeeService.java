package com.Demo.Employee.Employee;

import com.Demo.Employee.Department.Department;
import com.Demo.Employee.Department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();

        this.repository.findAll().forEach(employees::add);
        return employees;
    }

    public void createEmployee(EmployeeDTO employeeDTO){
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId()).orElseThrow();
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeePosition(employeeDTO.getEmployeePosition());
        employee.setDepartment(department);

        this.repository.save(employee);
    }

    public Employee findById(int employeeId){
        return repository.findById(employeeId).orElseThrow();
    }

    public Employee updateById(int employeeId, EmployeeDTO employeeDTO){
        Employee emp = this.findById(employeeId);

        if (employeeDTO.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDTO.getDepartmentId()).orElseThrow();
            emp.setDepartment(department);
        }

        if (employeeDTO.getEmployeeName() != null){
            emp.setEmployeeName(employeeDTO.getEmployeeName());
        }

        if (employeeDTO.getEmployeePosition() != null){
            emp.setEmployeePosition(employeeDTO.getEmployeePosition());
        }

        return repository.save(emp);
    }

    public void deleteById(int employeeId){
        repository.deleteById(employeeId);
    }
}
