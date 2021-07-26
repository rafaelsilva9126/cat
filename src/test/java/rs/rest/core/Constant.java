package rs.rest.core;

import io.restassured.http.ContentType;

public interface Constant {

	String APP_BASE_URL = "https://www.alphavantage.co/query";
	String APP_BASE_PATH = "";
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 10000L;
	
}
