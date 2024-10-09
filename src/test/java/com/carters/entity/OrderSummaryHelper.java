package com.carters.entity;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.carters.utils.GlobalConstants.STD_DATE_FORMAT;


public class OrderSummaryHelper {
    private static final Log log = LogFactory.getLog(OrderSummaryHelper.class);

    public enum CHANNEL {STORE,ONLINE}
    public static OrderSummary insertOrderSummary(String number,String customerID, CHANNEL channel, LocalDateTime orderedDate,String sourceChannel) throws Exception {
        OrderSummary order = new OrderSummary(number);
        order.customerID = customerID;
        order.appOrderFlag = sourceChannel;
        order.channelCode = channel.toString();
        order.orderDate = orderedDate.format(DateTimeFormatter.ofPattern(STD_DATE_FORMAT));
        order.updateToCDH();
        log.info("**Ordersummary :"+order.convertToJsonString());
        return order;
    }

    public static void main(String[] args) throws Exception {
        //OrderSummaryHelper.insertOrderSummary("20240717213024466",CHANNEL.STORE,LocalDateTime.now(),"Y");
    }
}
