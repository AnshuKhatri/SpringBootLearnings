package com.example.MongoDBDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.MongoDBDemo.Bean.Student;
import com.example.MongoDBDemo.Dao.StudentRepo;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbDemoApplication implements CommandLineRunner{


	@Autowired
	StudentRepo studentRepo;

	void createStudentEntry() {
		System.out.println("Data creation started...");
		studentRepo.save(new Student("Abc", "Abc", 10));
		studentRepo.save(new Student("Xyz", "Xyz", 15));
		System.out.println("Data creation complete...");
	}

	public void showAllStudents() {
		studentRepo.findAll().forEach(s -> System.out.println(getStudentDetails(s)));
	}
	
	public void getStudentByName(String name) {
		System.out.println("Getting item by name: " + name);
		Student s = studentRepo.findStudentByName(name);
		System.out.println(getStudentDetails(s));
	}

	public String getStudentDetails(Student s) {
		System.out.println("Student Name: " + s.getName() + ", \nAge: " + s.getAge()  );
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}

	@Override
    public void run(String[] args) { 
    System.out.println("-------------CREATE Student Entry------\n");
    createStudentEntry();

    System.out.println("\n------------SHOW ALL Students---\n");
    showAllStudents();
}

}