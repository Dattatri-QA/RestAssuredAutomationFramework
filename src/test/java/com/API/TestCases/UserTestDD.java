
package com.API.TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.API.EndPonts.UserEndPoints;
import com.API.PayLoad.User;
import com.API.Utilities.DataProviders;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import io.restassured.response.Response;

public class UserTestDD {

	public static Logger logger;
	
	@Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String UserID, String UserName, String fname, String lname, String email, String pwd, String phone)
	{
		User userPayload = new User();
		userPayload.setId(
			    (UserID == null || UserID.trim().isEmpty()) ? 0 : Integer.parseInt(UserID)
			);
		userPayload.setUsername(UserName);
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(lname);
		userPayload.setPassword(email);
		userPayload.setPhone(phone);
		Response response = UserEndPoints.createUser(userPayload);
		logger=LogManager.getLogger("RestAssuredAutomationFramework");


		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("testCreateUser user excuted");
	}
	@Test(priority = 2,dataProvider = "UserNamesData",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		Response response=	UserEndPoints.DeletUser(username);
		System.out.println(".....testDeleteUser.....");
		response.then()
		.log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("dataProvider user excuted");

	}

}
