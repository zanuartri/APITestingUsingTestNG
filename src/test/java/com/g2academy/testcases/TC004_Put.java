package com.g2academy.testcases;

import com.g2academy.base.TestBase;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC004_Put  extends TestBase {
	private String country = "Thailand";
	private int confirmed = 6000;
	private int recovered = 3000;
	private int deths = 100;

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("[TC004 Started]");

		JSONObject requestParams = new JSONObject();
		requestParams.put("country", country);
		requestParams.put("confirmed", confirmed);
		requestParams.put("recovered", recovered);
		requestParams.put("deaths", deths);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.PUT, "/covid19/" + covid19ID);
		
		Thread.sleep(5);
	}
		
	@Test
	public void putAssertion() {
		System.out.println("[PUT Assertion]");
		assertStatusCode(200);
		assertResponseBodyContains(country);
		assertResponseBodyContains(Integer.toString(confirmed));
		assertResponseBodyContains(Integer.toString(recovered));
		assertResponseBodyContains(Integer.toString(deths));
		assertStatusLine("HTTP/1.1 200 OK");
		assertContentType("application/json");
		assertServerType("Cowboy");
		assertVary("Accept-Encoding");
		assertContentLength(1500);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("[TC004 Finished]");
	}
}
