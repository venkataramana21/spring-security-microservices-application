package com.example.Project.service;

import com.example.Project.Dto.Res;
import com.example.Project.Dto.Response;
import com.example.Project.Repository.ProjectRepository;
import com.example.Project.fegin.InterviewInterface;
import com.example.Project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    InterviewInterface interviewInterface;

    public ResponseEntity<Project> createProject(Project p) {
        projectRepository.save(p);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    public ResponseEntity<Project> getProject(int id) {
        Project p=projectRepository.findById(id).get();
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

    public ResponseEntity<List<Project>> getAll() {
        List<Project>l=projectRepository.findAll();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    public ResponseEntity<Res> getDetails() {
        List<Response> l=interviewInterface.getSelectedEmployeeDetails().getBody();
        Project p=projectRepository.findById(1).get();
        Res r=new Res();
        r.setResponseList(l);
        r.setP(p);

        return new ResponseEntity<>(r,HttpStatus.OK);
    }
}
