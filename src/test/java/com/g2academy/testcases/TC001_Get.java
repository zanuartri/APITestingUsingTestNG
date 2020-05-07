package com.g2academy.testcases;

import com.g2academy.base.TestBase;
import io.restassured.http.Method;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC001_Get extends TestBase {
	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("[TC001 Started]");
		response = httpRequest.request(Method.GET, "/covid19");
		Thread.sleep(3);
	}

	@Test
	public void getAssertion() {
		System.out.println("[GET Assertion]");
		assertStatusCode(200);
		assertResponseBodyNotNull();
		assertResponseTime(5000);
		assertStatusLine("HTTP/1.1 200 OK");
		assertContentType("application/json");
		assertServerType("Cowboy");
		assertContentEncoding("gzip");
		assertTransferEncoding("chunked");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("[TC001 Finished]");
	}
}
