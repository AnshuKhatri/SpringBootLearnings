package com.example.MongoDBDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoDBDemo.Bean.Student;
import com.example.MongoDBDemo.service.StudentService;


@RestController
@Component
public class StudentController {

	@Autowired
	StudentService studentService;

   @GetMapping("/getStudentInfo")  
	public List<Student> getStudents() {
	
		return studentService.showAllStudents();
	}

}
