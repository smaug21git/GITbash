package com.ninza.hrm.api.BaseAPI;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ninza.hrm.api.GenericUtility.DataBaseUtility;
import com.ninza.hrm.api.GenericUtility.javaUtility;
import com.ninza.hrm.api.GenericUtility.propertyFileUtility;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIClass {
	
	public propertyFileUtility pLib= new propertyFileUtility();
	public javaUtility jLib= new javaUtility();
	public DataBaseUtility dLib= new DataBaseUtility();
	public static RequestSpecification specReq;
	public static ResponseSpecification specRes; 
	
	
	@BeforeSuite
	public void confifBS() throws Throwable {
		dLib.getDbConnectionWithCredentials();
		
		System.out.println("========connect to database=========");
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		//builder.setAuth(basic("username", "password"));
		//builder.addHeader("", "");
		builder.setBaseUri(pLib.toReadDataFromPropertyFile("BASEUri"));
		
		 specReq = builder.build();
		 
		 
		 ResponseSpecBuilder resBuilder= new ResponseSpecBuilder();
		 resBuilder.expectContentType(ContentType.JSON);
		  specRes = resBuilder.build();
	}
	
	@AfterSuite 
	public void configAS() throws Throwable {
		dLib.closeDbConnection();
		
		System.out.println("========disconnect to database=========");
		
	}
	

}
