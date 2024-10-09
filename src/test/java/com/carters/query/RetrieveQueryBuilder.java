package com.carters.query;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class RetrieveQueryBuilder {
    private static final String defaultQueryString ;

    static {
        try {
            defaultQueryString =  new String(Files.readAllBytes(Paths.get("src/main/resources/com/common/query/retrievequery.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateQueryFor(String primaryKey ,String primaryKeyValue, List<String> fields){
        String query = defaultQueryString.replaceFirst("PRIMARY_KEY",primaryKey);
        query = query.replace("PRIMARY_KEY_VALUE",primaryKeyValue);
        JSONObject finalQuery = new JSONObject(query);

        JSONObject obj = (JSONObject) finalQuery.get("query");

        JSONArray ja = new JSONArray();
        for (String field : fields){
            JSONObject jo = new JSONObject();
            jo.put("field",field);
            ja.put(jo);
        }
        obj.put("select",ja);

        return finalQuery.toString();
    }

    public static void main(String[] args) throws IOException {
        String[] list = {"FIELD1","FIELD2"};
        String q = generateQueryFor("CustomerID","20240717213024466", Arrays.asList(list));
        System.out.println(q);
    }

}
