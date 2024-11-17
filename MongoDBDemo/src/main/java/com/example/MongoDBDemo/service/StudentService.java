package com.example.MongoDBDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.MongoDBDemo.Bean.Student;
import com.example.MongoDBDemo.Dao.StudentRepo;
import com.example.MongoDBDemo.Request.StudentPartial;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public List<Student> showAllStudents() {
         List<Student> obj = new ArrayList<Student>();
                studentRepo.findAll().forEach(s->obj.add(s));
                return obj;
       
    }

   public String addStudent(Student student){
        studentRepo.save(student);
       
        return "Added Successfully";
    }
 
 
    public String deleteStudent(String id){
        studentRepo.deleteById(id);
       
        return "Deleted Successfully";
    }

    public String deleteStudentbyName(String name){
        studentRepo.deleteByName(name);
       
        return "Deleted Successfully";
    }
    
    public String updateStudent(String id,Student student){
        
        
        boolean exists= studentRepo.existsById(id);
System.out.println("exists"+exists);

        if(!exists) {
            return "Student with id "+id+" does not exists";
        }
        else{
            Student s= studentRepo.findById(id).get();

        s.setName(student.getName());
        s.setAge(student.getAge());
            studentRepo.save(s);
       
        return "Updated Successfully";

        }
        
        
        
    }

    public String partialUpdateStudent(String id,Map<String,String> name){
        
        
        boolean exists= studentRepo.existsById(id);
        //System.out.println("exists"+exists);

        if(!exists) {
            return "Student with id "+id+" does not exists";
        }
        else{
            Student s= studentRepo.findById(id).get();
            String attr=name.get("name");
            System.out.println("attr"+attr);

            s.setName(attr);
        
            studentRepo.save(s);
       
            return "Updated Successfully";

        }
        
        
        
    }
  
  
}

