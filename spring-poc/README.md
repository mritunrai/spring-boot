# spring-boot

## About Mockito and WireMock
What is Mocking ?
Mocks is nothing but an imitation. It simulates behaviour of a real component but in a more controlled manner.

Why Mocking ?
- Gives you an isolated environment for testing.
- Write the test for the resource that is not accessible.

## Wiremock
Wiremock is an open source library which can be used to mock HTTP-based APIs with ease. It creates an HTTP server which allows us to mock web services just like an actual server.

We can test our services by two different way using wiremock.

- Run standalone Wiremock server and create json file with request and response and copy into mapping folder
    Then run jar and execute all curl command.

- Using Java coding.Like starting Wiremock server and creating stub and then stop the Wiremock server.

## Mockito 
Mockito is a mocking framework, an open source JAVA library that allows to create and configure mock objects. Using Mockito we can add dummy functionality to a mock object and use it in our tests.

#### Usefull Link : https://medium.com/testvagrant/mocking-key-to-dependency-locks-256b4cad9481

## About PACT
PACT is used to do contract based testing to ensure messages which are being communicated among consumer and provider are in pre defined format.

We can perform contract testing using PACT or spring-cloud-contract .
