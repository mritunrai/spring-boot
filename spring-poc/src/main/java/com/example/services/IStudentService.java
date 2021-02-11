package com.example.services;

import java.util.List;

import com.example.exception.RecordNotFoundException;
import com.example.model.Student;

public interface IStudentService {
	List<Student> getAllStudents();
	Student findStduentByID(int id) throws RecordNotFoundException;
	public void addStudent(Student student);

}
