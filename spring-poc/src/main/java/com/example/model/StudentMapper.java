package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.model.*;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setName(rs.getString("name"));
		student.setEmail(rs.getString("email"));
		student.setMobile(rs.getInt("mobile"));
		
		return student;
	}
}