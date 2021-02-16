package com.example.controller;

import com.example.exception.RecordNotFoundException;
import com.example.model.*;
import com.example.services.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students/{studentId}")
	public Student retrieveStudentRecord(@PathVariable int studentId) throws RecordNotFoundException {
		return studentService.findStduentByID(studentId);
	}

	@GetMapping("/students")
	public List<Student> retrieveDetailsForCourse() {
		return studentService.getAllStudents();
	}

	@PostMapping("/addStudent")
	public int retrieveDetailsForCourse(@RequestBody Student student) {
		try {

			studentService.addStudent(student);

			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}