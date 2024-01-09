package utils;

import com.fasterxml.jackson.core.util.RequestPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportsManager;

import java.util.Map;

public class RestUtils {

    public static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String>headers){
        return RestAssured.
                given().
                baseUri(endPoint).
                contentType(ContentType.JSON).
                headers(headers).
                body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportsManager.logInfoDetails("EndPoint is - "+queryableRequestSpecification.getBaseUri());
        ExtentReportsManager.logInfoDetails("Headers are - "+queryableRequestSpecification.getHeaders());
        ExtentReportsManager.logInfoDetails("Request body is ");
        ExtentReportsManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportsManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportsManager.logInfoDetails("Response body is "+response.getBody().prettyPrint());
    }
    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String>headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }
}
