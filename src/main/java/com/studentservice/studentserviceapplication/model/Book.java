package com.studentservice.studentserviceapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String bookName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", student=" + student +
                '}';
    }

    public Book() {
    }

    public Book(long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
