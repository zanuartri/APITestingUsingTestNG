package com.g2academy.testcases;

import com.g2academy.base.TestBase;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC003_Post extends TestBase {
	private String country = "Indonesia";
	private int confirmed = 12000;
	private int recovered = 2000;
	private int deaths = 300;

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("[TC003 Started]");

		JSONObject requestParams = new JSONObject();
		requestParams.put("country", country);
		requestParams.put("confirmed", confirmed);
		requestParams.put("recovered", recovered);
		requestParams.put("deaths", deaths);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST, "/covid19");
		
		Thread.sleep(5);
	}
	
	@Test
	public void postAssertion() {
		System.out.println("[POST Assertion]");
		assertStatusCode(201);
		assertResponseBodyContains(country);
		assertResponseBodyContains(Integer.toString(confirmed));
		assertResponseBodyContains(Integer.toString(recovered));
		assertResponseBodyContains(Integer.toString(deaths));
		assertStatusLine("HTTP/1.1 201 Created");
		assertContentType("application/json");
		assertServerType("Cowboy");
		assertVary("Accept-Encoding");
		assertContentLength(1500);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("[TC003 Finished]");
	}
}
