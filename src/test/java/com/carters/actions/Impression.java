package com.carters.actions;

import com.carters.utils.PropertyHelper;
import com.carters.utils.RestAssuredUtil;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Impression {
    private static final String defaultRequestString ;
    public static final String INSERT_CHANNEL ="INSERT_CHANNEL";
    public static final String INSERT_EMAIL ="INSERT_EMAIL";

    public enum CHANNEL {Web,Mobile};

    static {
        try {
            defaultRequestString =  new String(Files.readAllBytes(Paths.get("src/test/resources/request/impression.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONArray createImpression(CHANNEL channel ,String emailAddress) throws Exception {
        String request = generateImpressionRequest(channel,emailAddress);
        Response response = RestAssuredUtil.invokePostAPI(getURL(),true,null,request);
        if(response.statusCode() == 200){
            return extractResults(response);
        }else{
            throw new Exception("Impression API call failed with error response code "+response.statusCode());
        }
    }

    private static JSONArray extractResults(Response response){
        JSONObject res = new JSONObject(response.getBody().print());
        JSONArray impressionResults = null;
        if(res.has("ContainerList")){
            JSONArray containerList = (JSONArray) res.get("ContainerList");
            impressionResults = new JSONArray();
            for(Object container : containerList){
                if(((JSONObject) container).has("RankedResults")){
                    impressionResults.putAll(((JSONObject) container).getJSONArray("RankedResults"));
                }
            }
        }        
        return  impressionResults;
    }

    private static String generateImpressionRequest(CHANNEL channel ,String emailAddress){
        String str = defaultRequestString.replaceFirst(INSERT_CHANNEL,channel.toString());
        str = str.replaceFirst(INSERT_EMAIL,emailAddress);
        return str;
    }

    private static String getURL(){
        return PropertyHelper.getContainerUrl();
//        return PropertyUtils.properties.getProperty(GlobalConstants.getEnv() + "." + "container_url");
    }

    public static void main(String[] args) throws Exception {

        String str = new String(Files.readAllBytes(Paths.get("src/test/resources/com/carters/cdh/response/impression.json")));
        JSONObject response = new JSONObject(str);
        JSONArray containerList = (JSONArray) response.get("ContainerList");
        JSONArray impressionResults = new JSONArray();
        for(Object container : containerList){
            impressionResults.putAll(((JSONObject) container).getJSONArray("RankedResults"));
        }
        System.out.println(impressionResults.toList());

        //Impression.createImpression(CHANNEL.Web,"automator@test.com");
    }
}
