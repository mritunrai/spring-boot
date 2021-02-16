package com.example.demo.integrationtesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Student;
import com.example.repositary.StudentRepositary;
import com.example.services.StudentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentIntegTest {

	@Autowired
	private StudentService stduentservice;

	@MockBean
	private StudentRepositary repositary;

	@Tag("student")
	@Test
	public void getAllStudents() {
		when(repositary.getAllStudents())
				.thenReturn(Stream.of(new Student("Danile", "sd", 9888), new Student("Huy", "mk@gmail.com", 8777))
						.collect(Collectors.toList()));
		assertEquals(2, stduentservice.getAllStudents().size());
	}

	@Test
	void justAnExample() {
		System.out.println("This test method should be run");
	}
}
