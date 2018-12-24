package stream.mokulive.storage.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenHelper {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${com.auth0.clientId}")
    private String clientId;

    @Value("${com.auth0.clientSecret}")
    private String clientSecret;

    @Value("${com.auth0.domain}")
    private String domain;

    public String getAccessToken() throws UnirestException {
        String token = "";
        //获取access token
        HttpResponse<String> response = null;
        response = Unirest.post("https://" + domain + "/oauth/token")
                .header("content-type", "application/json")
                .body("{\"client_id\":\"" + clientId + "\",\"client_secret\":\"" + clientSecret + "\",\"audience\":\"https://" + domain + "/api/v2/\",\"grant_type\":\"client_credentials\"}")
                .asString();
        String body = response.getBody();
        JSONObject json = new JSONObject(body);
        token = json.getString("access_token");
        return token;
    }
}
