package practiceRessured.reqres;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;
import utils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CreateEmp {

    @Test
    public void createNewEmp() throws IOException {

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String,String> data = JsonUtils.getJsonData(env+"/getUrl.json");

        String endPoint = data.get("createEndPoint");
        Map<String, Object> payload= Payloads.getCreatePayload("Sumana", "Senior Associate");

        Response response = RestUtils.performPost(endPoint,payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(),201);

    }

}
