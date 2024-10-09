package com.carters.entity;

import com.carters.query.InsertUpdateQueryBuilder;
import com.carters.query.RetrieveQueryBuilder;
import com.carters.utils.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static com.carters.utils.GlobalConstants.STD_DATE_FORMAT;


@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AbstractEntity {
    private static final ObjectMapper _objectMapper;
    private static final String jsonString ;
    protected static String[] mandatoryFields;

    public abstract String VIEW_NAME();
    public abstract String TABLE_NAME();

    static{
        _objectMapper = new ObjectMapper();
        _objectMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
        _objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        try {
            jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/entity/entity.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertToJsonString() throws JsonProcessingException {
        String jsonString =  _objectMapper.writeValueAsString(this);
        return jsonString;
    }

    public JSONObject convertToJsonObject() throws JsonProcessingException {
        String jsonString =  _objectMapper.writeValueAsString(this);
        return new JSONObject(jsonString);
    }

    public static <T extends AbstractEntity> T buildEntity(Class<T> entityType, DataTable table) throws Exception {
        List<List<String>> rows = table.asLists(String.class);
        AbstractEntity entity = entityType.newInstance();
        List<String> values = rows.get(1); // Headers always
        int index = 0;
        String value = null;
        for(String header : rows.get(0)){  // Read only 1 row as only 1 entity is generated. Rest all would be ignored here
            try {
                value = values.get(index);
                if(value.equals("TODAY_DATE")){
                    entity.setFieldValue(header, UtilityHelper.getCurrentDate(STD_DATE_FORMAT));
                }else if(value.contains("_DATE_")){
                    LocalDateTime datetime = UtilityHelper.getPastFutureDate(value);
                    entity.setFieldValue(header,datetime.format(DateTimeFormatter.ofPattern(STD_DATE_FORMAT)));
                }else{
                    entity.setFieldValue(header,value);
                }
            }catch (Exception error){
                throw new Exception("Could not insert customer to CDH due to error while populating the Customer entity.");
            }
            index++;
        }
        return (T) entity;
    }

    public static <T extends AbstractEntity> T getObject(Class<T> entityType, String jsonString) throws JsonProcessingException {
        return  _objectMapper.readValue(jsonString,entityType);
    }

    protected static <T extends AbstractEntity> T getDefaultObject(Class<T> entityType) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject obj =  jsonObject.getJSONObject(entityType.getSimpleName());
        return  _objectMapper.readValue(obj.toString(),entityType);
    }

    public static String[] getListOfMandatoryFields(){
        return mandatoryFields;
    }

    public void setFieldValue(String fieldName ,String fieldValue) throws Exception {
        try{
            Field field = this.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Class<?> clazz = field.getType();
            if (clazz.equals(Integer.TYPE) ||  clazz.getName().equals("int")) {
                field.setInt(this, Integer.parseInt(fieldValue));
            }else{
                field.set(this, fieldValue);
            }
        }catch(Exception error){
            throw new Exception(String.format("Could not set field %s with value %s for entity %s",fieldName,fieldValue,this.getClass().getSimpleName()));
        }
    }

    public void updateToCDH() throws Exception {
        String query = InsertUpdateQueryBuilder.generateQueryFor(TABLE_NAME(),this.convertToJsonObject());
        try{
            Response res = RestAssuredUtil.invokePostAPI(getUpdateURL(),true,null,query);
            if(res.statusCode() != 200) {
                throw new Exception(res.body().print());
            }
        }catch (Exception error){
            error.printStackTrace();
        }
    }

    public <T extends AbstractEntity> T loadFromCDH(String primaryKey ,String primaryID){
        String env = GlobalConstants.getEnv();
        String baseURL = PropertyHelper.getPrwebBaseUrl().concat("data_views/");
//        String baseURL = PropertyUtils.properties.getProperty(env + "." + "prweb_base_url")+"data_views/";
        String[] fields = Customer.DEFAULT().getListOfMandatoryFields();
        String q = RetrieveQueryBuilder.generateQueryFor(primaryKey,primaryID, Arrays.asList(fields));
        AbstractEntity entity = null;
        try{
            Response res = RestAssuredUtil.invokePostAPI(baseURL+ this.VIEW_NAME()+"List",true,null,q);

            if(res.statusCode() == 200){
                JSONObject responseJSONObject = new JSONObject(res.print());
                JSONArray events = (JSONArray) responseJSONObject.get("data");
                if(!events.isEmpty()){
                    entity = getObject(this.getClass(),events.get(0).toString());
                }
            }

        }catch (Exception e){
            System.out.println("Error while triggering post api");
            e.printStackTrace();
        }
        return (T) entity;
    }

    private String getUpdateURL(){
        return PropertyHelper.getPrwebBaseUrl()+"data/"+this.VIEW_NAME()+"Savable";
//        return PropertyUtils.properties.getProperty(GlobalConstants.getEnv() + "." + "prweb_base_url")+"data/"+this.VIEW_NAME()+"Savable";
    }

    private String getRetrieveURL(){
         return PropertyHelper.getPrwebBaseUrl()+"data_views/"+this.VIEW_NAME()+"List";
//        return PropertyUtils.properties.getProperty(GlobalConstants.getEnv() + "." + "prweb_base_url")+"data_views/"+this.VIEW_NAME()+"List";
    }

}
