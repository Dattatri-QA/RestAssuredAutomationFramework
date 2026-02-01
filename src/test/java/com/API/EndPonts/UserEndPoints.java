package com.API.EndPonts;

import com.API.PayLoad.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response=	given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(Routes.post_url);
		return response;
	}

	public static Response GetUser(String username) {
		Response response=	given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)

				.when()
				.get(Routes.get_url);
		return response;

	}
	public static Response UpdateUser(String username,User payload) {
		Response response=	given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)

				.when()
				.put(Routes.put_url);
		return response;

	}
	public static Response DeletUser(String username) {
		Response response=	given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.when()
				.delete(Routes.del_url );
		return response;

	}
}
