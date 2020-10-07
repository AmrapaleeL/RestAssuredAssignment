
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01GetReq {

	@Test
	void GetRequest()
	{
		//URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
		
		//Request
		RequestSpecification httpRequest = RestAssured.given(); 
		
		//Response
		Response response=httpRequest.request(Method.GET,"/1");
		
		//Status Code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status Code is " +statuscode);
		Assert.assertEquals(200, statuscode);
		
		String ResponseBody = response.getBody().asString();
		System.out.println("Response Body is " + ResponseBody);
		
		Assert.assertNotNull(ResponseBody);
		
	}
}
