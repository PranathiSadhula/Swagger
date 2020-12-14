package swaggers.pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import swaggers.SwaggersBase;

public class FindPetByStatus extends SwaggersBase {

	@Test
	public void testFindPetBySTatus() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
			
		Response resp = RestAssured
						.given()
						.get("pet/findByStatus?status=sold");
		
		JsonPath jsonresp = resp.jsonPath();
		jsonresp.prettyPrint();
		
		List<String> petIdList = jsonresp.getList("id");
		petid = petIdList.get(0);



	}
}
