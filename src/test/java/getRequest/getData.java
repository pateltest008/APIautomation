package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getData {
	
	@Test
	public void testBody() {
		Response resp = get("https://qvl7e.mocklab.io/tabsquare/employee/details");
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		String data = resp.asString();	
		JsonPath json = new JsonPath(data);
		
		//get adress details
		String addressDetail = json.getString("address");
		
		//Get Employee details
		String EmployeeDetails = json.getString("employeeDetails");
	}

}
