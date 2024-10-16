package com.example.Project.Controller;

import com.example.Project.Dto.Res;
import com.example.Project.Dto.Response;
import com.example.Project.fegin.InterviewInterface;
import com.example.Project.model.Project;
import com.example.Project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;



    @PostMapping("/add")
    public ResponseEntity<Project> createProject(@RequestBody Project p){
       return projectService.createProject(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id){
        return projectService.getProject(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAll(){
        return projectService.getAll();
    }

    @GetMapping("/details")
    public ResponseEntity<Res> getDetails(){
       return projectService.getDetails();
    }


}
