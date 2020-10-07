import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02PostRequest {

	@Test
	void PostRequest()
	{
		//URI
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		//Request
		RequestSpecification httpRequest = RestAssured.given(); 
		
		//Request payload
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("title", "foo");
		requestParams.put("body", "bar");
		requestParams.put("userId", "1");
		httpRequest.header("Content-type", "application/json; charset=UTF-8");
		
		httpRequest.body(requestParams.toJSONString());

		//Response
		Response response=httpRequest.request(Method.POST,"/posts");
		
		//Status Code validation
		int statuscode = response.getStatusCode();
		System.out.println("Status Code is " +statuscode);
		Assert.assertEquals(201, statuscode);
		
		String ResponseBody = response.getBody().asString();
		System.out.println("Response Body is " + ResponseBody);
				
		Assert.assertNotNull(ResponseBody);		
		
	}

}
