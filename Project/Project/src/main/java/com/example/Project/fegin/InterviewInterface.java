package com.example.Project.fegin;

import com.example.Project.Dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "Interview",url = "http://localhost:8081/interview")
public interface InterviewInterface {
    @GetMapping("/selectedStudents")
    public ResponseEntity<List<Response>> getSelectedEmployeeDetails();
}
