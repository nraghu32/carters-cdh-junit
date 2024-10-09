package com.carters.authentication;

import com.carters.utils.GlobalConstants;
import com.carters.utils.PropertyHelper;
import com.carters.utils.PropertyUtils;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;

import static io.restassured.RestAssured.given;

public class TokenCacheManger {

    private static final Log log = LogFactory.getLog(TokenCacheManger.class);
    private static Timestamp token_generatedTime ;
    private static long token_ttl ;
    private static String token;
    static PropertyHelper propertyHelper = new PropertyHelper();

    public static String getAuthToken(){
        if(token_generatedTime == null || token == null){
            log.debug("Generating Token for First time.");
            generateNewAuthToken();
        }else if(checkIfTokenIsExpired()){
            log.debug("Generating Token expired hence generating new token.");
            generateNewAuthToken();
        }
        return token;
    }

    private static boolean checkIfTokenIsExpired(){
        long diff = new Timestamp(System.currentTimeMillis()).getTime() - token_generatedTime.getTime();
        long minutes = diff / (60*1000);
        return minutes > 50;
    }

    private static void generateNewAuthToken() throws JSONException {
        String env = GlobalConstants.getEnv();
        String BASE_URI = propertyHelper.getAuthUrl();
//        String BASE_URI = PropertyUtils.properties.getProperty(env + "." + "oauth_url");
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type","client_credentials")
                .formParam("client_id", PropertyHelper.getOathClientId())
                .formParam("client_secret", PropertyHelper.getOauthClientSecret())

//                .formParam("client_id", PropertyUtils.properties.getProperty(env + "." + "oauth_client_id"))
//                .formParam("client_secret", PropertyUtils.properties.getProperty(env + "." + "oauth_client_secret"))
                .when()
                .post(BASE_URI);

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();
        String expiry = jsonObject.get("expires_in").toString();
        token = tokenType+ GlobalConstants.EMPTY_STRING +accessToken;
        token_generatedTime = new Timestamp(System.currentTimeMillis());
        token_ttl = Long.parseLong(expiry);
        log.info("Generated Auth Token Successfully");
    }

}
