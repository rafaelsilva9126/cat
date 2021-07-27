package rs.rest.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers. *;


import java.util.Map;


import org.junit.Assert;
import org.junit.Test;

import rs.rest.core.BaseTest;


public class ApiTest extends BaseTest {

	
	
	@Test
	public void mustSendInvalidRequest() {
			Map<String, String> names =
			given()
				.queryParam("function", "SYMBOL_SEARCH")
				.queryParam("keywords", "")
				.queryParam("apikey", "OA8DIY3HPLKG4C7F")
			.when()
					.get()
					
			.then()	
			.statusCode(200)
			.log().all()
			.extract().path("$");
	
			Assert.assertThat(names, hasKey("Error Message"));
		
	}
	
	@Test
	public void mustSendInexistedKeyword() {
			Map<String, String> names =
			given()
				.queryParam("function", "SYMBOL_SEARCH")
				.queryParam("keywords", "rafajisjsijs")
				.queryParam("apikey", "OA8DIY3HPLKG4C7F")
			.when()
					.get()
					
			.then()	
			.statusCode(200)
			.log().all()
			.extract().path("bestMatches[0]");
	
			Assert.assertThat(names, nullValue());
		
	}
	
	@Test
	public void mustReceiveData() {
		
		
			Map<String, String> names =
			given()
				.queryParam("function", "SYMBOL_SEARCH")
				.queryParam("keywords", "tesco")
				.queryParam("apikey", "OA8DIY3HPLKG4C7F")
			.when()
					.get()
			.then()
			.statusCode(200)
			.extract().path("bestMatches[0]");
	
		
			 Object[] objectArray = names.entrySet().toArray();
			
				for (int i = 0; i < objectArray.length; i++) {
					assertions(objectArray[i]);
					System.out.println(objectArray[i]);
				}			
				getKeyAssertions(names);
				;
		
		
	}
	
	private void getKeyAssertions(Map<String,String> names) {
		Assert.assertThat(names, hasKey("1. symbol"));
		Assert.assertThat(names, hasKey("2. name"));
		Assert.assertThat(names, hasKey("3. type"));
		Assert.assertThat(names, hasKey("4. region"));
		Assert.assertThat(names, hasKey("5. marketOpen"));
		Assert.assertThat(names, hasKey("6. marketClose"));
		Assert.assertThat(names, hasKey("7. timezone"));
		Assert.assertThat(names, hasKey("8. currency"));
		
	}

	public void assertions(Object objectArray) {
		Assert.assertThat(objectArray,  notNullValue());
	}


}	