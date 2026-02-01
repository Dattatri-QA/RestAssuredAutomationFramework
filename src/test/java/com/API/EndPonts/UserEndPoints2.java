package com.API.EndPonts;

import com.API.PayLoad.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

public class UserEndPoints2 {
	
	static ResourceBundle getURL() {
		ResourceBundle routes=ResourceBundle.getBundle("Routes");
		return routes;
	}

	public static Response createUser(User payload) {
		String post_url=getURL().getString("post_url");
		Response response=	given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(post_url);
		return response;
	}

	public static Response GetUser(String username) {
		String get_url=getURL().getString("get_url");
		Response response=	given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)

				.when()
				.get(get_url);
		return response;

	}
	public static Response UpdateUser(String username,User payload) {
		String put_url=getURL().getString("update_url");
		Response response=	given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)

				.when()
				.put(put_url);
		return response;

	}
	public static Response DeletUser(String username) {
		String del_url=getURL().getString("delete_url");
		Response response=	given()
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.when()
				.delete(del_url );
		return response;

	}
}
