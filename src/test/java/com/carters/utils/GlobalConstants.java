package com.carters.utils;

public class GlobalConstants {

    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String STD_DATE_FORMAT = "MM/dd/yyyy HH:mm";
    public static final String EMPTY_STRING = " ";
    public static String env_Staging = "staging";

    public static String getEnv(){
        String env = System.getProperty("environment");
        return env != null ? env : env_Staging;
    }
}
