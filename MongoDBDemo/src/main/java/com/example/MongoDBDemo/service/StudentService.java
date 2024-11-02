package com.example.MongoDBDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MongoDBDemo.Bean.Student;
import com.example.MongoDBDemo.Dao.StudentRepo;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public List<Student> showAllStudents() {
         List<Student> obj = new ArrayList<Student>();
                studentRepo.findAll().forEach(s->obj.add(s));
                return obj;
       
    }

}
