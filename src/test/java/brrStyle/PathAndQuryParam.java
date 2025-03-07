package brrStyle;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PathAndQuryParam {
	
	@Test
	public void GETAPIWithQueryParams() {
		RestAssured.baseURI = "https://gorest.co.in";
		given()
			.header("Authorization" , "Bearer 8cc2fb2d65333fab4f7a3aa752662dac66d862fb2afa9a5578155b94a3e9d32f")
			.queryParam("name", "Parvati Varrier")
			.queryParam("status","inactive")
		.when().log().all()
			.get("/public/v2/users")
		.then().log().all()		
			.assertThat()
			.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
		
	}
	@Test
	public void WithQueryParamsWithHashMap() {
		RestAssured.baseURI = "https://gorest.co.in";
			
		Map<String , String> queryMap = new HashMap<String, String>();
		queryMap.put("name","Parvati Varrier");
		queryMap.put("status","inactive");
		queryMap.put("gender","female");
		 
	
		/*
		  {
        "id": 7752430,
        "name": "Parvati Varrier",
        "email": "varrier_parvati@cormier-dicki.test",
        "gender": "female",
        "status": "inactive"
           }
		 */
		/*
			Map<String, String> queryMap =	Map.of(
				"name", "Parvati Varrier",
				"status", "inactive");
				*/
			
		given().log().all()
			.header("Authorization" , "Bearer 8cc2fb2d65333fab4f7a3aa752662dac66d862fb2afa9a5578155b94a3e9d32f")
			.queryParams(queryMap)
		.when().log().all()
			.get("/public/v2/users")
		.then().log().all()		
			.assertThat()
			.statusCode(200)
				.and()
				.contentType(ContentType.JSON);
	}
	
	@DataProvider
	public Object[][] getUserData() {
		return new Object[][] {
			{"7752430"},
			{"7752431"},
			{"7752429"}
			
		};
			}
	@Test(dataProvider = "getUserData")
	public void getUserAPI_WithPathParams(String userid) {
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
		.header("Authorization" , "Bearer 8cc2fb2d65333fab4f7a3aa752662dac66d862fb2afa9a5578155b94a3e9d32f")
		.pathParam("userid", userid)
	.when().log().all()
		.get("/public/v2/users/{userid}/posts")
	.then().log().all()		
		.assertThat()
		.statusCode(200)
			.and()
			.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void getAllFacilities_WithPathParams() {
		RestAssured.baseURI = "https://qsdev-release-kinetic.epicorsaas.com";
		given().log().all()
		.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
		.when().log().all()
		.get("/api/ngfacilities")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and();
		
		
	}
	
	@DataProvider
	public Object[][] geFacilityData() {
		return new Object[][] {
			{"4a2735f8-80fa-4314-84fc-abf0008a123e"},
			{"67d76779-a0e1-484b-a179-abfe008c84c8"},
			{"009f68f9-e4d5-4d34-81fe-acb400955b7f"}
		};
	}
	
	@Test(dataProvider = "geFacilityData")
	public void getAllFacilities_WithPathParamsDP(String facilityId)  {
		RestAssured.baseURI = "https://qsdev-release-kinetic.epicorsaas.com";
		given().log().all()
		.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
		.pathParam("facilityId", facilityId)
		.when().log().all()
		.get("/api/ngfacilities/{facilityId}")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and();
		
		
	}

}

//equalTo: json object {}
	//hasItem: Json Array []
	
	//jayway jsopath: $
