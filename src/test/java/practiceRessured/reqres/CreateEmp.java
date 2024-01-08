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
        Map<String, Object> payload = Payloads.getCreatePayload("Tirtha","lead");
        Response response = ReqResAPI.createEmp(payload);
        Assert.assertEquals(response.statusCode(),201);

    }

}
