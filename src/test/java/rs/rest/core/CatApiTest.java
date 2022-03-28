package rs.rest.core;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import io.restassured.RestAssured;


@RunWith(Parameterized.class)
public class CatApiTest {

	
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://http.cat/";
	}

	@Parameter
	public String resource;
	
	@Parameter(value=1)
	public Integer statusCode;
	
	@Test
	public void mustValidateCatWebSiteEndPoint() {
		RestAssured.given()
		.when()
			.get(resource)
		.then()
			.statusCode(statusCode);	
	}
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"/100", 200},
			{"/101", 200},
			{"/102", 200},
			{"/203", 200},
			{"/204", 200},
			{"/206", 200},
			{"/207", 200},
			{"/300", 200},
			{"/301", 200},
			{"/302", 200},
			{"/303", 200},
			{"/304", 200},
			{"/305", 200},
			{"/307", 200},
			{"/308", 200},
			{"/400", 200},
			{"/401", 200},
			{"/402", 200},
			{"/403", 200},
			{"/404", 200},
			{"/405", 200},
			{"/406", 200},
			{"/407", 200},
			{"/408", 200},
			{"/409", 200},
			{"/410", 200},
			{"/411", 200},
			{"/412", 200},
			{"/413", 200},
			{"/414", 200},
			{"/415", 200},
			{"/416", 200},
			{"/417", 200},
			{"/418", 200},
			{"/419", 404},
			{"/420", 200},
			{"/421", 200},
			{"/422", 200},
			{"/423", 200},
			{"/424", 200},
			{"/425", 200},
			{"/426", 200},
			{"/429", 200},
			{"/431", 200},
			{"/444", 200},
			{"/450", 200},
			{"/451", 200},
			{"/497", 200},
			{"/498", 200},
			{"/499", 200},
			{"/500", 200},
			{"/501", 200},
			{"/502", 200},
			{"/503", 200},
			{"/504", 200},
			{"/506", 200},
			{"/507", 200},
			{"/508", 200},
			{"/509", 200},
			{"/510", 200},
			{"/511", 200},
			{"/521", 200},
			{"/523", 200},
			{"/525", 200},
			{"/599", 200},
		});
	}
}
