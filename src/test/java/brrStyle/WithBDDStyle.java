package brrStyle;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class WithBDDStyle {
	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://qsdev-release-kinetic.epicorsaas.com";
	}
	
	//https://qsdev-release-kinetic.epicorsaas.com/token
	@Test
	public void getAllFacilities() {
		
		given().log().all()
		.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
		.when().log().all()
		.get("/api/ngfacilities")
		.then().log().all()
		.assertThat()
		.statusCode(200)
		.and();
		//.body("$.size()", equalTo(30));
		
	}
	@Test
	public void getAboutDeatils() {
		
		given().log().all()
		.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
		.when().log().all()
		.get("/api/about")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		//.and()
		//.body("$.size()", equalTo(30));
		
	}
	@Test
	public void getAllWorkStationDeatils() {
		
		given().log().all()
		.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
		.when().log().all()
		.get("/api/Workstation/ng/facility/eae72049-4cbd-459c-9a43-abf0006e730c")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		//.and()
		//.body("$.size()", equalTo(30));
		
	}
	@Test
	public void getRESTSettingDeatils() {
		
		given().log().all()
		.header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhZG1pbiIsImh0dHA6Ly9zY2hlbWFzLnhtbHNvYXAub3JnL3dzLzIwMDUvMDUvaWRlbnRpdHkvY2xhaW1zL25hbWUiOiJhZG1pbiIsImludGVncmF0aW9uX3R5cGUiOiJFcGljb3IxMCIsInJlZ2lzdHJhdGlvbkNvZGUiOiJRdWlja1NoaXBEZW1vIiwiY29tcGFueUlkIjoiYjAwMjc2ZGEtODg4MC00ZGIxLWI0ZWQtYTM5ZWQ3Mzc5N2I2IiwiaHR0cDovL3NjaGVtYXMubWljcm9zb2Z0LmNvbS93cy8yMDA4LzA2L2lkZW50aXR5L2NsYWltcy9hdXRoZW50aWNhdGlvbm1ldGhvZCI6IkJlYXJlciIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IklTQ19BZG1pbiIsImlzbmF0aXZlIjoiVHJ1ZSIsImNvbXBhbnlOYW1lIjoiRVBJQzA2IiwibmJmIjoxNzQxMDA3MzkyLCJleHAiOjE3NzI1NDMzOTIsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTA4MC8iLCJhdWQiOiJxdWlja3NoaXAifQ.97bbftlRAJKvC-vHnWi5Mmvd3YbOp1nRNlqtc6lU2RE")
		.when().log().all()
		.get("/api/restsettings/Kinetic")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		//.and()
		//.body("$.size()", equalTo(30));
		
	}


}
