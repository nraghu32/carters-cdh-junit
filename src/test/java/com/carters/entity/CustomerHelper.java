package com.carters.entity;

import io.cucumber.datatable.DataTable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CustomerHelper {

    private static final Log log = LogFactory.getLog(CustomerHelper.class);

    public static Customer insertCustomer(DataTable table, String newNumber) throws Exception {
        Customer customer = Customer.buildEntity(Customer.class,table);
        customer.lastName =newNumber;
        customer.customerID = newNumber;
        log.info("Thread->"+Thread.currentThread().getName()+" **Customer :"+customer.convertToJsonString());
        customer.updateToCDH();
        return customer;
    }

    public static Customer getCustomer(String customerID){
        Customer customer = Customer.DEFAULT().loadFromCDH("CustomerID",customerID);
        return customer;
    }

    public static void main(String[] args) throws Exception {
//        Date dt = DateUtils.addYears(new Date(),-30);
//        CustomerHelper.insertCustomer("Rag","hu",dt,"raghu@test.com");

/*        Customer cust = new Customer();
        cust.setFieldValue("rewardsPointsBalance","99");
        cust.setFieldValue("genderCode","1");
        System.out.println(cust.convertToJsonString());*/
        System.out.println(CustomerHelper.getCustomer("20240717213024466"));
    }
}
