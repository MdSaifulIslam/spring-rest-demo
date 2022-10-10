package com.springlearn.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	List<Student> theStudents;

	@PostConstruct
	public void loadStudents() {
		
		theStudents = new ArrayList<>();

		theStudents.add(new Student("saiful", "islam"));
		theStudents.add(new Student("jamal", "islam"));
		theStudents.add(new Student("kamal", "islam"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;

	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		return theStudents.get(studentId);
		
	}

}
