package maudev.portfolio.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import maudev.portfolio.project.entity.Project;
import maudev.portfolio.project.service.ProjectService;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){

        Project projectDB = projectService.createProject(project);

        if (projectDB == null) {
            return null;
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(projectDB);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProject(@PathVariable(value = "id") Long id){

        Project projectDB = projectService.getProject(id);

        if (projectDB == null) {
            return null;
        }
        return ResponseEntity.ok(projectDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long id , @RequestBody Project project){

        project.setId(id);
        Project projectDB = projectService.updaProject(project);

        if (projectDB == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(projectDB);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable(value = "id") Long id){
        Project projectDB = projectService.deleteProject(id);

        if (projectDB == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(projectDB);

        
    }

}
