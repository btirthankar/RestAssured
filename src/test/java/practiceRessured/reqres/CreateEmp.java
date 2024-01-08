package practiceRessured.reqres;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;

public class CreateEmp {

    @Test
    public void cerateNewEmp(){
        String endPoint = "https://reqres.in/api/users?page=2";
        String payload= "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(),201);

    }

}
