import org.json.simple.JSONObject;

import io.restassured.*;
import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Data_driven_exampleTestng {

	@DataProvider(name="data for post")
	public Object[][]dataForPost(){
		
		return new Object [][] {
			
			{"henry1","nicole1",1},
			{"henry2","nicole2",1},
			{"henry3","nicole3",1},
			{"henry4","nicole4",1}
		};
	}
	
	@Test(dataProvider = "data for post")
		public void useDatadriven_post(String firstname, String lastname, int subjectId) {
			
			JSONObject request= new JSONObject();
			
			request.put("firstname", firstname);
		      request.put("lastname", lastname);
		      request.put("subjectId", subjectId);
		      
		     given().contentType(ContentType.JSON).accept(ContentType.JSON).header("ContentType","application/json")
		     .body(request.toJSONString()).when().post("http://localhost:3000/users/").then().statusCode(201);
		}
	}
	

