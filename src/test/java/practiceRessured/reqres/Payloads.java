package practiceRessured.reqres;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static Map<String, Object> getCreatePayload(String name, String job){

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("name", name);
        payload.put("job", job);

    return payload;
    }

}
