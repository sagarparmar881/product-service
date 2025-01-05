package com.sagar.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	static {
		mongoDBContainer.start();
	}

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
                {
                    "name": "iPhone13",
                    "description": "Apple smartphone",
                    "price": 599
                }
                """;

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.log().body()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iPhone13"))
				.body("description", Matchers.equalTo("Apple smartphone"))
				.body("price", Matchers.equalTo(599));
	}

}
