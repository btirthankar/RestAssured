package utils;

import com.fasterxml.jackson.core.util.RequestPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {
    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String>headers){
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
