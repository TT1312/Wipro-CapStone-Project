package Test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import base.BaseClass;

import static io.restassured.RestAssured.given;

public class ApiTesting extends BaseClass{


	    @Test
	    public void testGetStatusCode() {
	        // Create a test in the Extent report
	        test = extent.createTest("Check API Status Code");

	        // Retrieve the base URI from the configuration
	        String baseUri = config.getProperty("BaseUrl");
	        String endpoint = "/favourites"; // Replace with your actual endpoint
	        
	        // Log the info about the GET request
	        test.info("Sending GET request to " + baseUri + endpoint);

	        // Send the GET request and get the response
	        Response response = given()
	                                .baseUri(baseUri)
	                            .when()
	                                .get(endpoint)
	                            .then()
	                                .extract().response();

	        // Get the status code from the response
	        int statusCode = response.getStatusCode();

	        // Assert the status code and log the result in the Extent report
	        if (statusCode == 200) {
	            test.pass("API responded with status code 200");
	        } else {
	            test.fail("API responded with status code " + statusCode);
	        }
	    }
	


}