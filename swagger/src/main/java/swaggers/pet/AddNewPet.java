package swaggers.pet;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import swaggers.SwaggersBase;

public class AddNewPet extends SwaggersBase{

	@Test
	public void testAddingANewPet() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
			
		Response resp = RestAssured
						.given()
						.contentType(ContentType.JSON)
						.body("{\r\n" + 
								"  \"id\": 0,\r\n" + 
								"  \"category\": {\r\n" + 
								"    \"id\": 0,\r\n" + 
								"    \"name\": \"Beckiee via RA 1\"\r\n" + 
								"  },\r\n" + 
								"  \"name\": \"doggie\",\r\n" + 
								"  \"photoUrls\": [\r\n" + 
								"    \"string\"\r\n" + 
								"  ],\r\n" + 
								"  \"tags\": [\r\n" + 
								"    {\r\n" + 
								"      \"id\": 0,\r\n" + 
								"      \"name\": \"This is a new pet added\"\r\n" + 
								"    }\r\n" + 
								"  ],\r\n" + 
								"  \"status\": \"available\"\r\n" + 
								"}")
						.post("/pet");
		
		JsonPath jsonresp = resp.jsonPath();
		jsonresp.prettyPrint();
		petid = jsonresp.get("id");

	}
}
