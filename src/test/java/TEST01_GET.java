import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TEST01_GET {

	@Test
	void Test_01() {
		
	Response response=	RestAssured.get("https://reqres.in/api/users?page=2");
	
	System.out.println(response.asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getBody());
	System.out.println(response.getStatusLine());
	System.out.println(response.getTime());
	System.out.println(response.getHeader("content-type"));
	
	    int statusCode=response.getStatusCode();
	    Assert.assertEquals(statusCode, 200);
	}
	
	//or other method for verify
	
	@Test
	void Test_02() {
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
	}
	
	
	
	
	
	
	
	
	
	
}
