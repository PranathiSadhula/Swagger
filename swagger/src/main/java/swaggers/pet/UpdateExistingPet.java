package swaggers.pet;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateExistingPet {

	@Test
	public void testUpdatingExistingPet() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = RestAssured
						.given()
						.accept("*/*")
						.contentType(ContentType.JSON)
						.body("{\r\n" + 
								"    \"id\": 9222968140491044000,\r\n" + 
								"    \"category\": {\r\n" + 
								"        \"id\": 0,\r\n" + 
								"        \"name\": \"Updated Pet\"\r\n" + 
								"    },\r\n" + 
								"    \"name\": \"doggie\",\r\n" + 
								"    \"photoUrls\": [\r\n" + 
								"        \"string\"\r\n" + 
								"    ],\r\n" + 
								"    \"tags\": [\r\n" + 
								"        {\r\n" + 
								"            \"id\": 0,\r\n" + 
								"            \"name\": \"Hey! Pettiee Your Name is Updated via RA 3!!!!!!\"\r\n" + 
								"        }\r\n" + 
								"    ],\r\n" + 
								"    \"status\": \"sold\"\r\n" + 
								"}")
						.log()
						.all()
						.put("/pet");
		
		resp.prettyPrint();
		
		
		

	}
}
