package com.carters.entity;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class ChildrenHelper {
    private static final Log log = LogFactory.getLog(ChildrenHelper.class);
    public static Children insertChildren(String number,String customerID, String firstName, int age, Optional<Boolean> notCurrentMonth) throws Exception {
        Children child = new Children(number);
        child.firstName = firstName;
        child.customerID = customerID;
        child.age = age;

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(notCurrentMonth.isPresent()){
            localDate = localDate.minusMonths(1);
        }
        child.birthYear = localDate.getYear() -age;
        child.birthDay = localDate.getDayOfMonth();
        String month = String.valueOf(localDate.getMonthValue());
        child.birthMonth = month.length() == 1 ? "0"+month : month;
        child.updateToCDH();
        log.info("**Children :"+child.convertToJsonString());
        return child;
    }

    public static void main(String[] args) throws Exception {
/*        int age = 12;
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.minusMonths(1);
        System.out.println(localDate.getYear() -age);
        System.out.println(localDate.getDayOfMonth());
        String month = String.valueOf(localDate.getMonthValue());
        System.out.println(month.length() == 1 ? "0"+month : month);*/
        //ChildrenHelper.insertChildren("20240722162441146","Arya",12, Optional.of(true));
    }
}
