package com.Demo.Employee.Project;

import com.Demo.Employee.Employee.Employee;
import com.Demo.Employee.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList<>();
        this.projectRepository.findAll().forEach(projects::add);
        return projects;
    }

    public void createProject(Project project){
        this.projectRepository.save(project);
    }

    public Project findById(int projectId){
        return this.projectRepository.findById(projectId).orElseThrow();
    }

    public void addEmployee(int id, int employeeId){
        Project proj = projectRepository.findById(id).orElseThrow();
        Employee emp = employeeRepository.findById(employeeId).orElseThrow();

        proj.getEmployees().add(emp);

        projectRepository.save(proj);
    }

    public Project update(int projectId, Project newProjectDetails){
        Project proj = this.findById(projectId);

        if (newProjectDetails.getProjectName() != null){
            proj.setProjectName(newProjectDetails.getProjectName());
        }

        if (newProjectDetails.getEmployees() != null){
            proj.setEmployees(newProjectDetails.getEmployees());
        }

        return projectRepository.save(proj);

    }

    public void delete(int id){
        projectRepository.deleteById(id);
    }


}
