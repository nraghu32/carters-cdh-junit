package com.carters.entity;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmailHelper {
    private static final Log log = LogFactory.getLog(EmailHelper.class);
    public static Email insertEmail(String number,String customerID) throws Exception {
        Email email = new Email(number);
        email.customerID = customerID;
        email.emailAddress = customerID+"@test.com";
        log.info("**Email :"+email.convertToJsonString());
        email.updateToCDH();
        return email;
    }

}
