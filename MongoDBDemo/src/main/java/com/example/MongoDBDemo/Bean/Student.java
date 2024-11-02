package com.example.MongoDBDemo.Bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Student")

public class Student {

    @Id
		private String id;

		private String name;
		private int age;
		
		public Student(String id, String name, int age) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
		}

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


}
