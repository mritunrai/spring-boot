package com.example.demo.integrationtesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.services.StudentService;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class StudentIntegTest {
	
	private StudentService studentService;
	
	private WireMockServer wireMockServer;
	
	 @BeforeEach
	    void setup() {
	        wireMockServer = new WireMockServer();
	        WireMock.configureFor("localhost", 8080);
	        wireMockServer.start();
	    }
	
	
	@Test
	public void exactUrlOnly() {
		  WireMock.configureFor("localhost", 8080);
		  
		stubFor(get(urlEqualTo("/students"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "text/plain")
						.withBody(fileToJSON("student_get_response.json"))));
	}

	@AfterEach
    void tearDown() {
        wireMockServer.stop();
    }
}
