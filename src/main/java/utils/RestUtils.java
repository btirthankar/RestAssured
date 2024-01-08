package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class RestUtils {
    public static Response performPost(String endPoint, String requestPayload, Map<String, String>headers){
        return RestAssured.
                given().
                baseUri(endPoint).
                contentType(ContentType.JSON).
                headers(headers).
                body(requestPayload).
                post().
                then().log().all().extract().response();
    }
}
