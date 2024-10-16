package com.example.Project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interview {
    private int interviewId;
    private String candidateName;
    private String position;
    private LocalDateTime interviewDate;
    private String empid;
    private String status;
}
