package com.Demo.Employee.Project;

import com.Demo.Employee.Employee.Employee;
import com.Demo.Employee.Employee.EmployeeService;
import com.Demo.Employee.Project.DTO.AddEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Project> getAllProjects(){
        return this.projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable int id){
        return projectService.findById(id);
    }


    @PostMapping
    public void createProject(@RequestBody Project project){
        this.projectService.createProject(project);
    }

    @PostMapping(value="/{id}/employees")
    public void addEmployee(@PathVariable int id, @RequestBody AddEmployeeDto addEmployeeDto){
        this.projectService.addEmployee(id, addEmployeeDto.getEmployeeId());
    }

    @PatchMapping("/{id}")
    public Project update(@PathVariable int id, @RequestBody Project newProjectDetails){
        return projectService.update(id, newProjectDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        projectService.delete(id);
    }

}
