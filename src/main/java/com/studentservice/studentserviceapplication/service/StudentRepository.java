package com.studentservice.studentserviceapplication.service;

import com.studentservice.studentserviceapplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
