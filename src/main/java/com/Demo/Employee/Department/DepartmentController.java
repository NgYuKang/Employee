package com.Demo.Employee.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> getAll(){
        return this.service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Department findById(@PathVariable int id){
        return this.service.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Department dept){
        this.service.create(dept);
    }

    @PatchMapping(value = "/{id}")
    public Department update(@PathVariable int id, @RequestBody Map<String, Object> fields){
        return this.service.update(id, fields);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id){
        this.service.deleteById(id);
    }

}
