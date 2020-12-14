package swaggers.store;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import swaggers.SwaggersBase;

public class PlaceOrder extends SwaggersBase {

	@Test
	public void testPlacingAnOrderForPet() {
		//Step1 : setup base_url for swagger
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		
			
		Response resp = RestAssured
						.given()
						.contentType(ContentType.JSON)
						.body(" {\r\n" + 
								"  \"id\": 9,\r\n" + 
								"  \"petId\": \""+petid+"\",\r\n" + 
								"  \"quantity\": 0,\r\n" + 
								"  \"shipDate\": \"2020-12-11T13:46:31.349Z\",\r\n" + 
								"  \"status\": \"placed\",\r\n" + 
								"  \"complete\": true\r\n" + 
								"}")
						.post("/store/order");
		
		JsonPath jsonresp = resp.jsonPath();
		jsonresp.prettyPrint();

	}
}
