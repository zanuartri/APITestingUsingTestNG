package com.g2academy.testcases;

import com.g2academy.base.TestBase;
import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC002_GetById extends TestBase {
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("[TC002 Started]");
		response = httpRequest.request(Method.GET, "/covid19/" + covid19ID);
		Thread.sleep(3);
	}

	@Test
	public void getByIdAssertion() {
		System.out.println("[GET By ID Assertion]");
		assertStatusCode(200);
		assertResponseBodyContains(covid19ID);
		assertResponseTime(3000);
		assertStatusLine("HTTP/1.1 200 OK");
		assertContentType("application/json");
		assertServerType("Cowboy");
		assertVary("Accept-Encoding");
		assertContentLength(1500);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("[TC002 Finished]");
	}
}
