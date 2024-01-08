package practiceRessured.reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllEmp {
    @Test
    public void getAllEmp(){
        Response response = RestAssured.given().log().all().baseUri("https://reqres.in/api/users?page=2").get();
        Assert.assertEquals(response.statusCode(),200);
    }
}
