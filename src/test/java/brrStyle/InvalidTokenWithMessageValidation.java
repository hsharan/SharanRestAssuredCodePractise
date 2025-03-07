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
}
