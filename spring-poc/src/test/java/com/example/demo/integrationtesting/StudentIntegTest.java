package com.example.demo.integrationtesting;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

@RunWith(SpringRunner.class)
@SpringBootTest()

public class StudentIntegTest {
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089);

	@BeforeEach
	public void setUpClass() {
		System.out.println("Wiremock server has been started!");
		wireMockRule.start();
	}

	@AfterEach
	public void tearDownClass() {

		System.out.println("Wiremock server is going to be stopped!");
		wireMockRule.stop();
	}

	@Test
	@Tag("integ")
	public void exampleTest() {

		System.out.println("Test is going to be executed!");

		stubFor(get(urlEqualTo("/my/resource")).withHeader("Accept", equalTo("text/xml"))
				.willReturn(aResponse().withStatus(200)
                    .withHeader("Content-Type", "text/xml")
                    .withBody("<response>Some content</response>")
				));

//        Result result = myHttpServiceCallingObject.doSomething();
//
//        assertTrue(result.wasSuccessful());

//        verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
//                .withRequestBody(matching(".*<message>1234</message>.*"))
//                .withHeader("Content-Type", notMatching("application/json")));
	}
}