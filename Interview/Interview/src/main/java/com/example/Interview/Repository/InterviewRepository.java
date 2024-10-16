package com.example.Interview.Repository;

import com.example.Interview.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    @Query(value = "Select * from Interview where status=:status",nativeQuery = true)
//    @Query(value = "SELECT * FROM Interview WHERE status = 'PASSED' ", nativeQuery = true)
    List<Interview> findByStatusEqualsPASSED(String status);
}
