package com.carters.utils;


import com.carters.authentication.TokenCacheManger;
import com.carters.entity.Customer;
import com.carters.query.RetrieveQueryBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredUtil {
    private static final Log logger = LogFactory.getLog(RestAssuredUtil.class);

    public static Response invokePostAPI(String endpoint, boolean authTokenRequired, Map<String,String> headers, String jsonBody) throws Exception {
        logger.trace("Begin - Triggering invokePostAPI");
        try {
            RequestSpecification res = given();
            if(authTokenRequired){
                res.header("Authorization", TokenCacheManger.getAuthToken());
            }
            if (logger.isDebugEnabled()) {
                res = res.log().all();
            }
            ValidatableResponse response = res.body(jsonBody).when().post(new URL(endpoint)).then();
            if(logger.isDebugEnabled()){
                response = response.log().all();
            }
            return response.extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static Response invokeGetAPI(String endpoint, boolean authTokenRequired, Map<String,String> headers) throws Exception {
        logger.trace("Begin - Triggering invokeGetAPI");
        try {
            RequestSpecification res = given();
            if(authTokenRequired){
                res.header("Authorization", TokenCacheManger.getAuthToken());
            }
            if (logger.isDebugEnabled()) {
                res = res.log().all();
            }
            ValidatableResponse response = res.get(new URL(endpoint)).then();
            if (logger.isDebugEnabled()) {
                response = response.log().all();
            }
            return response.extract().response();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        String env = GlobalConstants.getEnv();
       String baseURL = PropertyHelper.getPrwebBaseUrl().concat("data_views/");
//        String baseURL = PropertyUtils.properties.getProperty(env + "." + "prweb_base_url")+"data_views/";
        String[] fields = Customer.DEFAULT().getListOfMandatoryFields();
        String q = RetrieveQueryBuilder.generateQueryFor("CustomerID","150000000029", Arrays.asList(fields));
        try{
            Response res = invokePostAPI(baseURL+ Customer.DEFAULT().VIEW_NAME(),true,null,q);
            res.body().prettyPrint();
        }catch (Exception e){
            System.out.println("Error while triggering post api");
            e.printStackTrace();
        }
        baseURL = PropertyHelper.getIhUrl().concat("?CustomerID=200000000368&AppID=PE");
//        baseURL = PropertyUtils.properties.getProperty(env + "." + "ih_url")+"?CustomerID=200000000368&AppID=PE";
        try{
            Response res = invokeGetAPI(baseURL,false,null);
            res.body().prettyPrint();
        }catch(Exception e){
            System.out.println("Error while triggering get api");
            e.printStackTrace();
        }

    }

}
