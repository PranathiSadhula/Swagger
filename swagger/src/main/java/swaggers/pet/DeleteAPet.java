package swaggers.pet;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteAPet {

	@Test
	public void testDeletingPet() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
			
		Response resp = RestAssured
						.given()
						.log()
						.all()
						.delete("/pet/9222968140496862726");
		
		JsonPath jsonresp = resp.jsonPath();
		jsonresp.prettyPrint();

	}
}
