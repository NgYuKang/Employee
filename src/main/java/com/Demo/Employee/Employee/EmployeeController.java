package com.Demo.Employee.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll(){
        return this.service.getAllEmployees();
    }

    @GetMapping(value = "/{id}")
    public Employee get(@PathVariable int id){
        return this.service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody EmployeeDTO employee){
        this.service.createEmployee(employee);
    }

    @PatchMapping(value = "/{id}")
    public Employee update(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO){
        return service.updateById(id ,employeeDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }


}
