package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);


	}


	public static List<Student> getStudents(){
		List<Student> students = new ArrayList<Student>(){{
			add(new Student(1));
			add(new Student(2));
			add(new Student(3));
			add(new Student(4));
		}};
		return students;
	}



	public static class Student{


		private Integer id;

		public Student(Integer id){
			this.id = id;
		}


		public Integer getId(){
			return id;
		}
	}

}
