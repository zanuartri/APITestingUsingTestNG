package com.g2academy.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	public String covid19ID = "9";

	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://5e9fa8e411b078001679c9e5.mockapi.io/g2academy/";
		httpRequest = RestAssured.given();
	}
	
	public void assertStatusCode(int expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode);
	}
	
	public void assertResponseBodyNotNull() {
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody != null);
	}
	
	public void assertResponseBodyContains(String data) {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(data), true);
	}
	
	public void assertResponseTime(int maxResponseTime) {
		long responseTime = response.getTime();
		Assert.assertTrue(responseTime <= maxResponseTime);
	}
	
	public void assertStatusLine(String expectedStatusLine) {
		String actualStatusLine = response.getStatusLine();
		Assert.assertEquals(actualStatusLine, expectedStatusLine);
	}
	
	public void assertContentType(String expectedContentType) {
		String actualContentType = response.header("Content-Type");
		Assert.assertEquals(actualContentType, expectedContentType);
	}
	
	public void assertServerType(String expectedServerType) {
		String actualServerType = response.header("Server");
		Assert.assertEquals(actualServerType, expectedServerType);
	}
	
	public void assertContentEncoding(String expectedContentEncoding) {
		String actualContentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(actualContentEncoding, expectedContentEncoding);
	}
	
	public void assertTransferEncoding(String expectedTransferEncoding) {
		String actualTransferEncoding = response.header("Transfer-Encoding");
		Assert.assertEquals(actualTransferEncoding, expectedTransferEncoding);
	}
	
	public void assertVary(String expectedVary) {
		String actualVary = response.header("Vary");
		Assert.assertEquals(actualVary, expectedVary);
	}
	
	public void assertContentLength(int maxContentLength) {
		String contentLength = response.header("Content-Length");
		Assert.assertTrue(Integer.parseInt(contentLength) <= maxContentLength);
	}
}
