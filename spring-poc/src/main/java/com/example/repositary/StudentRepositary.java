package com.example.repositary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.exception.RecordNotFoundException;
import com.example.model.*;

import com.example.model.Student;

@Repository
public class StudentRepositary implements IStudentRepositary {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private final String INSERT_SQL = "INSERT INTO student(name,email,mobile) values(?,?,?)";
	private final String FETCH_SQL = "select id,name, email,mobile from student";
	private final String FETCH_SQL_BY_ID = "select * from student where id = ?";

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(FETCH_SQL, new StudentMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student findStduentByID(int id) throws RecordNotFoundException {

		Student student = null;

		try {
			student = (Student) jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new StudentMapper());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
			throw new RecordNotFoundException("Student record not found!");
		}
		return student;
	}

	@Override
	public void addStudent(Student student) {
		try {
			jdbcTemplate.update(INSERT_SQL,
					new Object[] { student.getName(), student.getEmail(), student.getMobile() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
