package com.studentservice.studentserviceapplication.service;

import com.studentservice.studentserviceapplication.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentDao {

    @PersistenceContext
    EntityManager em;

    public void insertStudent(Student student){
        em.persist(student);
    }
}
