package com.example.Interview.Controller;

import com.example.Interview.Dto.Response;
import com.example.Interview.Service.InterviewService;
import com.example.Interview.model.Interview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @PostMapping("/add")
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview){
        return interviewService.createInterView(interview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interview> getById(@PathVariable int id){
        return interviewService.getById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interview>> getAll(){
        return interviewService.getAll();
    }
    @GetMapping("/getStatus/{status}")
    public ResponseEntity<List<Interview>> getPassedInterview(@PathVariable String status){
        return interviewService.getPassedInterview(status);
    }
    @GetMapping("/selectedStudents")
    public ResponseEntity<List<Response>> getSelectedEmployeeDetails(){
        return interviewService.getSelectedEmployeeDetails();
    }
}
