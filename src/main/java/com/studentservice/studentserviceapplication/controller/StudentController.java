package com.studentservice.studentserviceapplication.controller;

import com.studentservice.studentserviceapplication.model.Student;
import com.studentservice.studentserviceapplication.service.StudentDao;
import com.studentservice.studentserviceapplication.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentDao dao;

    @Autowired
    StudentRepository repo;
    @PostMapping(path = "persist_student")
    public void saveStudent(@RequestBody Student student){
        dao.insertStudent(student);
    }
    @PostMapping(path = "new_student")
    public void persistStudent(@RequestBody Student student){
        repo.save(student);
    }
    @GetMapping("Students")
    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    @GetMapping(path = "Student/{id}")
    public Student getStudentById(@PathVariable long id){
        Optional<Student> byId = repo.findById(id);
        return byId.get();
    }
}
