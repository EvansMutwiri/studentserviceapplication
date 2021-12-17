package com.studentservice.studentserviceapplication.service;

import com.studentservice.studentserviceapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
