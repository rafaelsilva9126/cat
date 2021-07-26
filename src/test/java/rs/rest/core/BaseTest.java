package rs.rest.core;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constant  {

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.basePath = APP_BASE_PATH;
	
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(APP_CONTENT_TYPE);
		reqBuilder.addQueryParam("function", "SYMBOL_SEARCH");
		reqBuilder.addQueryParam("keywords", "tesco");
		reqBuilder.addQueryParam("apikey", "OA8DIY3HPLKG4C7F");
		RestAssured.requestSpecification = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resBuilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	
}
