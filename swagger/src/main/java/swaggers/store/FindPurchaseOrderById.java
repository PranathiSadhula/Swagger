package swaggers.store;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FindPurchaseOrderById {

	@Test
	public void testPlacingAnOrderForPet() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
			
		Response resp = RestAssured
						.given()
						.contentType(ContentType.JSON)
						.get("/store/order/1");
		
		JsonPath jsonresp = resp.jsonPath();
		jsonresp.prettyPrint();

	}
}
