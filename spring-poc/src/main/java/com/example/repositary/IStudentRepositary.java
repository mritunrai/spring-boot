package com.example.repositary;

import java.util.List;

import com.example.exception.RecordNotFoundException;
import com.example.model.*;

public interface IStudentRepositary {
	List<Student> getAllStudents();
	Student findStduentByID(int id) throws RecordNotFoundException;
	public void addStudent(Student student);
}
