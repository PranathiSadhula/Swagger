package swaggers.pet;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateExistingPetUsingFormData {

	@Test
	public void testUpdatingExistingPet() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = RestAssured
						.given()
						.contentType(ContentType.URLENC)
						.formParam("name", "sample name")
						.formParam("status", "sold")
						.log()
						.all()
						.put("/pet/9222968140496862726");
		
		resp.prettyPrint();
		

	}
}
