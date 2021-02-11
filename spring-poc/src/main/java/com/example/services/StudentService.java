package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.RecordNotFoundException;
import com.example.model.Student;
import com.example.repositary.StudentRepositary;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentRepositary studentRepositary;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepositary.getAllStudents();
	}

	@Override
	public Student findStduentByID(int id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return studentRepositary.findStduentByID(id);
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepositary.addStudent(student);
	}

}
