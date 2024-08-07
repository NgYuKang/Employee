package com.Demo.Employee.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public List<Department> getAll() {
        List<Department> res = new ArrayList<>();

        this.repository.findAll().forEach(res::add);
        return res;
    }

    public Department findById(Integer deptId) {
        return this.repository.findById(deptId).orElseThrow();
    }

    public void create(Department dept) {
        this.repository.save(dept);
    }

    public Department update(int id, Map<String, Object> fields) {
        Department dept = this.findById(id);
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Department.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, dept, value);
                field.setAccessible(false);
            }
        });

        return this.repository.save(dept);
    }

    public void deleteById(Integer deptId) {
        this.repository.deleteById(deptId);
    }

}
