package com.example.MongoDBDemo.Request;

import org.springframework.data.annotation.Id;

public class StudentPartial {


     @Id
		private int age;
	
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
}
