package com.carters.functions;

import com.carters.utils.PropertyHelper;

import com.carters.utils.RestAssuredUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InteractionHistory {
    private static final Logger logger = LogManager.getLogger("InteractionHistory");
    private static String baseURL;

    public static ResponseBody getIHResultsForCustomer(String customerID) {
        if(baseURL == null){

            baseURL = PropertyHelper.getIhUrl();
//            baseURL = PropertyUtils.properties.getProperty(GlobalConstants.getEnv() + "." + "ih_url");
        }
        String finalUrl = baseURL+"?CustomerID="+customerID+"&AppID=PE";
        try{
            Response res = RestAssuredUtil.invokeGetAPI(finalUrl,false,null);
            return res.body();
        }catch(Exception e){
            logger.error("Error while triggering get api");
            e.printStackTrace();
        }
        return null;
    }

}
