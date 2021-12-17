package com.studentservice.studentserviceapplication.controller;

import com.studentservice.studentserviceapplication.model.Book;
import com.studentservice.studentserviceapplication.model.Student;
import com.studentservice.studentserviceapplication.service.BookRepository;
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

    @Autowired
    BookRepository bookRepo;

    @PostMapping(path = "persist_student")
    public void saveStudent(@RequestBody Student student){
        dao.insertStudent(student);
    }

    @PostMapping(path = "new_student")
    public void persistStudent(@RequestBody Student student){
        repo.save(student);
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    @GetMapping(path = "student/{id}")
    public Student getStudentById(@PathVariable long id){
        Optional<Student> byId = repo.findById(id);
        return byId.get();
    }

    @GetMapping(path = "getBooksById/{id}")
    public List<Book> getBooksById(@PathVariable long id){
        Student byId = repo.getById(id);
        return byId.getAllBooks();
    }

//    @GetMapping(path = "getAllStudentBooks")
//    public List<Student> getAllBooks(){
//        return repo.findAll();
//    }

    @PostMapping(path = "add_book")
    public void addBook(@RequestBody Book book) {
        bookRepo.save(book);
    }

    @GetMapping("allBooks")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
