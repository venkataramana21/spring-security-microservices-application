package com.example.Interview.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Interview {
    @Id
    private int interviewId;
    private String candidateName;
    private String position;
    private LocalDateTime interviewDate;
    private String empid;
    private String status;
}
