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

}

//equalTo: json object {}
	//hasItem: Json Array []
	
	//jayway jsopath: $
