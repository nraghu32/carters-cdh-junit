package com.carters.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderSummary extends AbstractEntity{
    static {
        mandatoryFields = new String[]{"SourceOrderID","CustomerID","ChannelCode","OrderDate","AppOrderFlag"};
    }

    public OrderSummary(){}

    public OrderSummary(String number){
        this.sourceOrderID = number;
    }

    public static OrderSummary DEFAULT()  {
        OrderSummary os = null;
        try {
            //Load from default entity json file
            os = getDefaultObject(OrderSummary.class);
        }catch (Exception e){
            //Do nothing
        }
        return os;
    }
    @JsonProperty("SourceOrderID")
    public String sourceOrderID;
    @JsonProperty("CustomerID")
    public String customerID;
    @JsonProperty("HouseholdID")
    public String householdID;
    @JsonProperty("AdditionalAddressID")
    public String additionalAddressID;
    @JsonProperty("AddressID")
    public String addressID;
    @JsonProperty("AppOrderFlag")
    public String appOrderFlag;
    @JsonProperty("BOPISOrder")
    public String bOPISOrder;
    @JsonProperty("BOSSOrder")
    public String bOSSOrder;
    @JsonProperty("BrandCode")
    public String brandCode;
    @JsonProperty("DerivedBrand")
    public String derivedBrand;
    @JsonProperty("ChannelCode")
    public String channelCode;
    @JsonProperty("ClientKey")
    public String clientKey;
    @JsonProperty("CompStoreFlag")
    public String compStoreFlag;
    @JsonProperty("CostOfGoodsSold")
    public String costOfGoodsSold;
    @JsonProperty("CurrencyCtryOrigin")
    public String currencyCtryOrigin;
    @JsonProperty("DiscountAmt")
    public String discountAmt;
    @JsonProperty("DiscountFlag")
    public String discountFlag;
    @JsonProperty("EmailID")
    public String emailID;
    @JsonProperty("EmailAddress")
    public String emailAddress;
    @JsonProperty("EmployeeSaleInd")
    public String employeeSaleInd;
    @JsonProperty("GuestCustomerFlag")
    public String guestCustomerFlag;
    @JsonProperty("LastReturnDate")
    public String lastReturnDate;
    @JsonProperty("LoyaltyID")
    public String loyaltyID;
    @JsonProperty("MarginAmt")
    public String marginAmt;
    @JsonProperty("NonMerchandiseAmt")
    public String nonMerchandiseAmt;
    @JsonProperty("NonMerchandiseQty")
    public String nonMerchandiseQty;
    @JsonProperty("OrderCtryOrigin")
    public String orderCtryOrigin;
    @JsonProperty("OrderDate")
    public String orderDate;
    @JsonProperty("OrderStatus")
    public String orderStatus;
    @JsonProperty("OrderStartTime")
    public String orderStartTime;
    @JsonProperty("NetAmt")
    public String netAmt;
    @JsonProperty("OriginalAmt")
    public String originalAmt;
    @JsonProperty("OriginalOrderID")
    public String originalOrderID;
    @JsonProperty("PaymentAmt")
    public String paymentAmt;
    @JsonProperty("PurchaseAmt")
    public String purchaseAmt;
    @JsonProperty("PurchaseQty")
    public String purchaseQty;
    @JsonProperty("RegisterID")
    public String registerID;
    @JsonProperty("ReturnAmt")
    public String returnAmt;
    @JsonProperty("ReturnQty")
    public String returnQty;
    @JsonProperty("SalesAssociate")
    public String salesAssociate;
    @JsonProperty("StoreID")
    public String storeID;
    @JsonProperty("VisitID")
    public String visitID;
    @JsonProperty("FulfilledItemQty")
    public String fulfilledItemQty;
    @JsonProperty("FulfilledNetAmt")
    public String fulfilledNetAmt;
    @JsonProperty("FulfilledMarginAmt")
    public String fulfilledMarginAmt;
    @JsonProperty("FulfilledDIscountAmt")
    public String fulfilledDIscountAmt;
    @JsonProperty("FulfilledDate")
    public String fulfilledDate;
    @JsonProperty("PendingItemQty")
    public String pendingItemQty;
    @JsonProperty("PendingNetAmt")
    public String pendingNetAmt;
    @JsonProperty("PendingMarginAmt")
    public String pendingMarginAmt;
    @JsonProperty("PendingDiscountAmt")
    public String pendingDiscountAmt;
    @JsonProperty("CancelledItemQty")
    public String cancelledItemQty;
    @JsonProperty("CancelledNetAmt")
    public String cancelledNetAmt;
    @JsonProperty("RptItemQty")
    public String rptItemQty;
    @JsonProperty("RptNetAmt")
    public String rptNetAmt;
    @JsonProperty("RptMarginAmt")
    public String rptMarginAmt;
    @JsonProperty("RptDiscountAmt")
    public String rptDiscountAmt;
    @JsonProperty("GiftFlag")
    public String giftFlag;
    @JsonProperty("TaxAmt")
    public String taxAmt;
    @JsonProperty("Source")
    public String source;
    @JsonProperty("FirstPurchase")
    public String firstPurchase;

    @Override
    public String VIEW_NAME() {
        return "D_OrderSummary";
    }

    @Override
    public String TABLE_NAME() {
        return "CTRS-PE-Data-OrderSummary";
    }
}
