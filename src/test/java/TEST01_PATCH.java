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

public class TEST01_PATCH {

	@Test
	void Test_01_patch() {
		
	
	JSONObject request=new JSONObject();
	request.put("name", "shivam");
	request.put("job", "CEO");
	 
	System.out.println(request);
	System.out.println(request.toJSONString());
	given().header("Content-Type","aplication/json").contentType(ContentType.JSON).body(request.toJSONString())
	
	 .when().patch("https://reqres.in/api/users/2")
	      .then().statusCode(200).body("name",equalTo("shivam")).log().all();
	
	
	
	}
	
	//or other method for verify
	
	
	   
	
	
	
	
	
	
	
	
}
