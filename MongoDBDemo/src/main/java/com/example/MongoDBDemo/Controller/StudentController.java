package com.example.MongoDBDemo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MongoDBDemo.Bean.Student;
import com.example.MongoDBDemo.Request.StudentPartial;
import com.example.MongoDBDemo.service.StudentService;


@RestController
@Component
@CrossOrigin("*")
public class StudentController {

	@Autowired
	StudentService studentService;

   @GetMapping("/getStudentInfo")  
	public List<Student> getStudents() {
	
		return studentService.showAllStudents();
	}


	@PostMapping("/addStudentInfo")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
       
        return "Added Successfully";
    }
 
 
   /*  @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
       
        return "Deleted Successfully";
    }*/

	@DeleteMapping("/delete/{name}")
    public String deleteStudentbyName(@PathVariable String name){
        studentService.deleteStudentbyName(name);
       
        return "Deleted Successfully";
    }

	@PutMapping("/put/{id}")
    public String updateStudentbyId( @PathVariable String  id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
       
     
    }

	//studentpartial - 1 way of patching

	//
	@PatchMapping("/student/{id}")
    public String partialupdatebyId( @PathVariable String  id,@RequestBody Map<String,String> name){
        return studentService.partialUpdateStudent(id,name);
       
     
	}


}
