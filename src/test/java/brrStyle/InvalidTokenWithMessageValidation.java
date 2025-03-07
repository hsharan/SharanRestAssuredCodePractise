package brrStyle;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class InvalidTokenWithMessageValidation {
	
	@Test
	public void getContactsAPITest_WithInvalidToken() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

		given().log().all()
			.header("Authorization", "Bearer -AnGV8c")
				.when().log().all()
					.get("/contacts")
						.then().log().all()
							.assertThat()
									.statusCode(401)
										.and()
											.body("error", equalTo("Please authenticate."));

	}
@Test
	public void getContactsAPITest_WithInvalidToken_ExtarctMEthod() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";

		String errorMesg = given().log().all()
				.header("Authorization", "Bearer -AnGV8c")
					.when().log().all()
						.get("/contacts")
							.then()
								.extract()
									.path("error");
			
			System.out.println(errorMesg);
			Assert.assertEquals(errorMesg, "Please authenticate.");
					
	}
@Test
public void getSingleUser_FetchSingleUSerData_with_JsonPath() {
	RestAssured.baseURI = "https://gorest.co.in";
	
	Response response = given()
		.header("Authorization", "Bearer 8cc2fb2d65333fab4f7a3aa752662dac66d862fb2afa9a5578155b94a3e9d32f")
			.when()
				.get("/public/v2/users/7752430");
					
	
	System.out.println("status code: " + response.statusCode());
	System.out.println("status line: " + response.statusLine());
	response.prettyPrint();
	
	JsonPath js = response.jsonPath();
	
	int userId = js.getInt("id");
	System.out.println("user id : " + userId);
	
	String userName = js.getString("name");
	System.out.println("user name : " + userName);
	
	String status = js.getString("status");
	System.out.println("status : " + status);		
	
}
@Test
public void getFullSetUser_FetchSingleUSerData_with_JsonPath() {
RestAssured.baseURI = "https://gorest.co.in";
	
	Response response = given().log().all()
		.header("Authorization", "Bearer 8cc2fb2d65333fab4f7a3aa752662dac66d862fb2afa9a5578155b94a3e9d32f")
			.when().log().all()
				.get("/public/v2/users");
	
	JsonPath js = response.jsonPath();
	List<Integer> ids = js.getList("id");
	System.out.println(ids);
	
	List<String> names =js.getList("name");
	System.out.println(names);
	System.out.println("=========");
	for(Integer e : ids) {
		System.out.println(e);
	}
	System.out.println("=========");
	for(String e : names) {
		System.out.println(e);
	}
		
}


@Test
public void FetchNestedData_with_JsonPath() {
	RestAssured.baseURI = "https://fakestoreapi.com";
	
	
	Response response = given()
			.when()
				.get("/products");
	
	JsonPath js = response.jsonPath();
	
	List<Integer> ids = js.getList("id");
	System.out.println(ids);
	System.out.println("=========");
	
	
	List<Object> prices = js.getList("price");
	System.out.println(prices);
	System.out.println("=========");
	
	
	List<Object> rateList = js.getList("rating.rate");
	System.out.println(rateList);
	System.out.println("=========");
	
	List<Integer> countList = js.getList("rating.count");
	System.out.println(countList);
	
	for(int i=0; i<ids.size();i++) {
		int id = ids.get(i);
		Object price = prices.get(i);
		Object rate = rateList.get(i);
		int count = countList.get(i);
		System.out.println("ID: " + id + " price : " + price + " rate : " + rate + " count : " + count );
	}
	
	
	
}

@Test
public void facility_FetchNestedData_with_JsonPath() {
	RestAssured.baseURI = "https://qsdev-release-kinetic.epicorsaas.com";
	Response response  = given().log().all()
	.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
	.when().log().all()
	.get("/api/ngfacilities");
	
	response.prettyPrint();
	JsonPath js = response.jsonPath();
	
	List<Object> facilityId = js.getList("result.facilities.facilityId");
	System.out.println(facilityId);
	System.out.println("=========");
	
	//description
	
	List<String> description = js.getList("result.facilities.description");
	System.out.println(description);
	System.out.println("=========");
	
	for(int i=0; i<facilityId.size();i++) {
		
		Object fId = facilityId.get(i);
		String desc = description.get(i);
		System.out.println("facilityId: " + fId + " Description : " +desc );
	}
}
}
