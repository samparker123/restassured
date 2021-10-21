import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.*;
import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ExamplesOnLocal {

	
	@Test(priority=1)
	public void Test_get() {
		
		//JSONObject request=new JSONObject();
		baseURI="http://localhost:3000/";
		
		given().get("/users")
		.then().statusCode(200).body("firstname", hasItem ("shivam")).log().all();
	}
	
	//@Test(priority=2)
	
	public void Test_post() {
		
		JSONObject request=new JSONObject();
		request.put("firstname", "Ed ");
		request.put("lastname", "Sheeran");
		request.put("subjectId", 1);
		//request.put("Id", 4);
		
		baseURI="http://localhost:3000/";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type","application/json")
		.body(request.toJSONString())
		.when().post("/users")
		.then().statusCode(201).log().all();
		
	}
	
	@Test(priority=3)
	public void Test_put() {
		
		
		JSONObject request= new JSONObject();
		
		request.put("lastname", "walker");
		request.put("firstname", "alen");
		request.put("subjectId", "2");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json").body(request.toJSONString())
		.when().put("/users/z9cZEGg").then().statusCode(200).body("lastname", equalTo("walker")).log().all();
		
	}
	
	@Test(priority=4)
	public void Test_patch() {
		
		JSONObject request =new JSONObject();
		request.put("firstname", "johnny");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type","application/json").body(request.toJSONString())
		.when().patch("/users/z9cZEGg").then().statusCode(200).body("firstname",equalTo ("johnny")).log().all()
		;
	}
	
	@Test(priority=5)
	
	public void Test_delete() {
		
		given().delete("/users/psoojvN").then().statusCode(200).log().all();
		
		
	}
}


