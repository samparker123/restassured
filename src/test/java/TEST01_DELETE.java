import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TEST01_DELETE {

	@Test
	void Test_01_delete() {
		
	when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	
	
	
	}
	
	//or other method for verify
	
	
	   
	
	
	
	
	
	
	
	
}
