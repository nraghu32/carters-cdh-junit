package com.carters.utils;

import lombok.Getter;

import java.io.*;
import java.util.Properties;

public class PropertyHelper {
    public static Properties properties;


    //    public Properties initProp() {
    final static String propertyFilePath = "%s/application.properties";
    @Getter
    public static String containerUrl;
    @Getter
    public static String IhUrl;
    @Getter
    public static String PrwebBaseUrl;
    @Getter
    public static String AuthUrl;
    @Getter
    public static String OathClientId;
    @Getter
    public static String OauthClientSecret;

//
//    {
//        String environment = System.getProperty("environment");
//        if (environment != null || environment.trim().isEmpty()) {
//            environment = "properties/staging";
//        }
//
//        properties = new Properties();
//        InputStream input = null;
//        try {
//            input = PropertyHelper.class.getClassLoader().getResourceAsStream(String.format(propertyFilePath, environment));
//            properties.load(input);
//            containerUrl = properties.getProperty("ContainerUrl");
//            IhUrl = properties.getProperty("IhUrl");
//            PrwebBaseUrl = properties.getProperty("PrwebBaseUrl");
//            AuthUrl = properties.getProperty("AuthUrl");
//            OathClientId = properties.getProperty("OathClientId");
//            OauthClientSecret = properties.getProperty("OauthClientSecret");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    //public static final Properties properties;

    static {
        try {
            properties = getProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties getProperties() throws IOException {
        {
            String environment = System.getProperty("environment");
            if (environment != null || environment.trim().isEmpty()) {
                environment = "properties/staging";
            }

            properties = new Properties();
            InputStream input = null;
            try {
                input = PropertyHelper.class.getClassLoader().getResourceAsStream(String.format(propertyFilePath, environment));
                properties.load(input);
                containerUrl = properties.getProperty("ContainerUrl");
                IhUrl = properties.getProperty("IhUrl");
                PrwebBaseUrl = properties.getProperty("PrwebBaseUrl");
                AuthUrl = properties.getProperty("AuthUrl");
                OathClientId = properties.getProperty("OathClientId");
                OauthClientSecret = properties.getProperty("OauthClientSecret");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }
}
