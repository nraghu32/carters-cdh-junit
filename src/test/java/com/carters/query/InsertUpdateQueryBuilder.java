package com.carters.query;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InsertUpdateQueryBuilder {

    private static final String defaultQueryString ;

    static {
        try {
            defaultQueryString =  new String(Files.readAllBytes(Paths.get("src/test/resources/query/insertquery.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateQueryFor(String tableName , JSONObject payload){
        payload.put("pxObjClass",tableName);
        JSONObject finalQuery = new JSONObject(defaultQueryString);
        finalQuery.put("data",payload);
        return finalQuery.toString();
    }

    public static void main(String[] args) throws IOException {
        String q = generateQueryFor("CTRS-PE-Data-Customer",new JSONObject("{ \"CustomerID\": \"150000000203\",\"FirstName\": \"gkc1\"}"));
        System.out.println(q.toString());
    }
}
