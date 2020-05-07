package com.g2academy.testcases;

import com.g2academy.base.TestBase;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC005_Delete extends TestBase {
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("[TC005 Started]");

		response = httpRequest.request(Method.GET, "/covid19");

		JsonPath jsonPathEvaluator = response.jsonPath();
		String covid19ID = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/covid19/" + covid19ID);
		
		Thread.sleep(3);
	}
	
	@Test
	public void deleteAssertion() {
		System.out.println("[DELETE Assertion]");
		assertStatusCode(200);
		assertStatusLine("HTTP/1.1 200 OK");
		assertContentType("application/json");
		assertServerType("Cowboy");
		assertVary("Accept-Encoding");
		assertContentLength(1500);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("[TC005 Finished]");
	}
}
