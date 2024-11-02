package com.example.MongoDBDemo.Dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.MongoDBDemo.Bean.Student;
@Repository
@Component
public interface StudentRepo extends MongoRepository<Student, String> {
	
	@Query("{name:'?0'}")
	Student findStudentByName(String name);
	
	@Query(value="{age:'?0'}", fields="{'name' : 1}")
	List<Student> findAll(String category);



	
	
}
