package com.carters.utils;

import java.sql.Timestamp;

public class NumberGenerator {

    static final NumberGenerator instance = new NumberGenerator();

    private NumberGenerator(){}

    public static NumberGenerator getInstance() {
        return instance;
    }

    public synchronized String generateUniqueNumber() throws InterruptedException {
        Thread.sleep(100);
        return new Timestamp(System.currentTimeMillis()).toString().replaceAll("[^0-9]", "");
    }
}
