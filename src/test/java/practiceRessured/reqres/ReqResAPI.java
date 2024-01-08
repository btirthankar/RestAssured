package practiceRessured.reqres;

import io.restassured.response.Response;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class ReqResAPI {
    public static Response createEmp(Map<String, Object> createAPI) {
        String endPoint = (String) Base.dataFromJsonFile.get("createEndPoint");
        Response response = RestUtils.performPost(endPoint, createAPI, new HashMap<String, String>());
        return response;
    }
}
