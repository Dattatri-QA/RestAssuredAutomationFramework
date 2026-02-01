package com.API.TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API.EndPonts.UserEndPoints2;
import com.API.PayLoad.User;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UserTest2 {

	Faker faker;
	User userpayload;
	public static Logger logger;

	@BeforeClass
	public void generateTestData() {
		faker=new Faker();
		userpayload=new User();

		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=LogManager.getLogger("RestAssuredAutomationFramework");
	}

	@Test(priority = 1)
	public void testCreatUser() {
		Response response=	UserEndPoints2.createUser(userpayload);
		System.out.println(".....testCreatUser.....");
		response.then()
		.log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("Create user excuted UserEndPoints2");

	}
	@Test(priority = 2)
	public void testGetUserData() {
		Response response=	UserEndPoints2.GetUser(this.userpayload.getUsername());
		System.out.println(".....testGetUserData.....");
		response.then()
		.log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("Get user Data UserEndPoints2");

	}
	@Test(priority = 3)
	public void testUpdateUser() {
		userpayload.setFirstname(faker.name().firstName());
		Response response=	UserEndPoints2.UpdateUser(this.userpayload.getUsername(),userpayload);
		response.then()
		.log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		Response responsePostUpdate=UserEndPoints2.GetUser(this.userpayload.getUsername());
		System.out.println(".....After Update User Data.....");
		responsePostUpdate.then().log().all();
		logger.info("Update user Data UserEndPoints2");

	}
	@Test(priority = 4)
	public void testDeleteUser() {
		Response response=	UserEndPoints2.DeletUser(this.userpayload.getUsername());
		System.out.println(".....testDeleteUser.....");
		response.then()
		.log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("Deleted user Data UserEndPoints2");

	}



}
