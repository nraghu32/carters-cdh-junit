package com.carters.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer extends AbstractEntity {
    /*
     *
     * Below static declaration is used for Retrieving and Create/update api calls query building.
     */
    static{
        mandatoryFields = new String[]{"CustomerID", "City","FirstName","DateOfBirth","EmailOptInDate",
        "EmailOptInFlag","GenderCode","HouseholdID","Language","LastName","PostalCode",
        "StateProvince","SmsOptInFlag","SmsOptInDate","ClosestStore","DistanceToClosestStore","LifetimeTxnCnt",
        "PLCCCardHolder", "RewardsPointsBalance", "TxnCntLast12Mo"};
    }
    // Default values populated from the entity.json for quick test data
    public static Customer DEFAULT()  {
        Customer cus = null;
        try {
            //Load from default entity json file
           cus = getDefaultObject(Customer.class);
        }catch (Exception e){
            //Do nothing
        }
        return cus;
    }

    public Customer(){}

    public Customer(String number){
        this.customerID = number;
    }
    @JsonProperty(value = "CustomerID")
    public String customerID;
    @JsonProperty("AppUserFlag")
    public String appUserFlag;
    @JsonProperty("AttitudinalSegment")
    public String attitudinalSegment;
    @JsonProperty(value = "City")
    public String city;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("Brand")
    public String brand;
    @JsonProperty("CaNcoaNixieInd")
    public String caNcoaNixieInd;
    @JsonProperty("CountryCode")
    public String countryCode;
    @JsonProperty("CreatedDate")
    public String createdDate;
    @JsonProperty("DateOfBirth")
    public String dateOfBirth;
    @JsonProperty("DeceasedFlag")
    public String deceasedFlag;
    @JsonProperty("DNSFlag")
    public String dNSFlag;
    @JsonProperty("DNSFlagDate")
    public String dNSFlagDate;
    @JsonProperty("EmailOptInDate")
    public String emailOptInDate;
    @JsonProperty("EmailOptInFlag")
    public String emailOptInFlag;
    @JsonProperty("EmployeeFlag")
    public String employeeFlag;
    @JsonProperty("FacebookID")
    public String facebookID;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("GenderCode")
    public int genderCode;
    @JsonProperty("HouseholdID")
    public int householdID;
    @JsonProperty("InstagramID")
    public String instagramID;
    @JsonProperty("Language")
    public String language;
    @JsonProperty("LastLoginDate")
    public String lastLoginDate;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("LastVisitDate")
    public String lastVisitDate;
    @JsonProperty("LatestSource")
    public String latestSource;
    @JsonProperty("LTV")
    public String lTV;
    @JsonProperty("MaxProcessDate")
    public String maxProcessDate;
    @JsonProperty("OriginalFirstName")
    public String originalFirstName;
    @JsonProperty("OriginalLastName")
    public String originalLastName;
    @JsonProperty("OriginalMiddleName")
    public String originalMiddleName;
    @JsonProperty("OriginalSource")
    public String originalSource;
    @JsonProperty("PLCCCardHolder")
    public String pLCCCardHolder;
    @JsonProperty("PostalCode")
    public int postalCode;
    @JsonProperty("PrefixName")
    public String prefixName;
    @JsonProperty("PriceSensitivity")
    public String priceSensitivity;
    @JsonProperty("ReportedGender")
    public String reportedGender;
    @JsonProperty("ScreamersFlag")
    public String screamersFlag;
    @JsonProperty("ScreamersFlagDate")
    public String screamersFlagDate;
    @JsonProperty("SFSCID")
    public String sFSCID;
    @JsonProperty("SourceCreatedDate")
    public String sourceCreatedDate;
    @JsonProperty("StateProvince")
    public String stateProvince;
    @JsonProperty("SuffixName")
    public String suffixName;
    @JsonProperty("TaxExempt")
    public String taxExempt;
    @JsonProperty("TwitterHandle")
    public String twitterHandle;
    @JsonProperty("VIPCustomerFlag")
    public String vIPCustomerFlag;
    @JsonProperty("VIPCustomerVisual")
    public String vIPCustomerVisual;
    @JsonProperty("VulgarNameFlag")
    public String vulgarNameFlag;
    @JsonProperty("ZipPlus")
    public String zipPlus;
    @JsonProperty("CANLastRtlDate")
    public String cANLastRtlDate;
    @JsonProperty("MiddleName")
    public String middleName;
    @JsonProperty("OriginalDate")
    public String originalDate;
    @JsonProperty("LastTransactionDate")
    public String lastTransactionDate;
    @JsonProperty("SmsOptInFlag")
    public String smsOptInFlag;
    @JsonProperty("SmsOptInDate")
    public String smsOptInDate;
    @JsonProperty("ProspectFlag")
    public String prospectFlag;
    @JsonProperty("BUCountry")
    public String bUCountry;
    @JsonProperty("FirstTxnDate")
    public String firstTxnDate;
    @JsonProperty("LastTxnDate")
    public String lastTxnDate;
    @JsonProperty("FirstTxnDateNewbaby")
    public String firstTxnDateNewbaby;
    @JsonProperty("LastTxnDateNewbaby")
    public String lastTxnDateNewbaby;
    @JsonProperty("FirstTxnDateBaby")
    public String firstTxnDateBaby;
    @JsonProperty("LastTxnDateBaby")
    public String lastTxnDateBaby;
    @JsonProperty("FirstTxnDateToddler")
    public String firstTxnDateToddler;
    @JsonProperty("LastTxnDateToddler")
    public String lastTxnDateToddler;
    @JsonProperty("FirstTxnDateKid")
    public String firstTxnDateKid;
    @JsonProperty("LastTxnDateKid")
    public String lastTxnDateKid;
    @JsonProperty("FirstTxnDateBigKid")
    public String firstTxnDateBigKid;
    @JsonProperty("LastTxnDateBigKid")
    public String lastTxnDateBigKid;
    @JsonProperty("FirstTxnDateBoy")
    public String firstTxnDateBoy;
    @JsonProperty("LastTxnDateBoy")
    public String lastTxnDateBoy;
    @JsonProperty("FirstTxnDateGirl")
    public String firstTxnDateGirl;
    @JsonProperty("LastTxnDateGirl")
    public String lastTxnDateGirl;
    @JsonProperty("FirstTxnDateNeutral")
    public String firstTxnDateNeutral;
    @JsonProperty("LastTxnDateNeutral")
    public String lastTxnDateNeutral;
    @JsonProperty("FirstTxnDateAccessories")
    public String firstTxnDateAccessories;
    @JsonProperty("LastTxnDateAccessories")
    public String lastTxnDateAccessories;
    @JsonProperty("FirstTxnDateBoysPlaywear")
    public String firstTxnDateBoysPlaywear;
    @JsonProperty("LastTxnDateBoysPlaywear")
    public String lastTxnDateBoysPlaywear;
    @JsonProperty("FirstTxnDateGirlsPlaywear")
    public String firstTxnDateGirlsPlaywear;
    @JsonProperty("LastTxnDateGirlsPlaywear")
    public String lastTxnDateGirlsPlaywear;
    @JsonProperty("FirstTxnDateOuterwear")
    public String firstTxnDateOuterwear;
    @JsonProperty("LastTxnDateOuterwear")
    public String lastTxnDateOuterwear;
    @JsonProperty("FirstTxnDateShoes")
    public String firstTxnDateShoes;
    @JsonProperty("LastTxnDateShoes")
    public String lastTxnDateShoes;
    @JsonProperty("FirstTxnDateSleepwear")
    public String firstTxnDateSleepwear;
    @JsonProperty("LastTxnDateSleepwear")
    public String lastTxnDateSleepwear;
    @JsonProperty("FirstTxnDateSwimwear")
    public String firstTxnDateSwimwear;
    @JsonProperty("LastTxnDateSwimwear")
    public String lastTxnDateSwimwear;
    @JsonProperty("FirstTxnDateOnline")
    public String firstTxnDateOnline;
    @JsonProperty("LastTxnDateOnline")
    public String lastTxnDateOnline;
    @JsonProperty("FirstTxnDateStore")
    public String firstTxnDateStore;
    @JsonProperty("LastTxnDateStore")
    public String lastTxnDateStore;
    @JsonProperty("FirstTxnChannel")
    public String firstTxnChannel;
    @JsonProperty("LastTxnChannel")
    public String lastTxnChannel;
    @JsonProperty("FirstTxnNetAmt")
    public String firstTxnNetAmt;
    @JsonProperty("LastTxnNetAmt")
    public String lastTxnNetAmt;
    @JsonProperty("FirstTxnOrderID")
    public String firstTxnOrderID;
    @JsonProperty("LastTxnOrderID")
    public String lastTxnOrderID;
    @JsonProperty("FirstTxnBrands")
    public String firstTxnBrands;
    @JsonProperty("LastTxnBrands")
    public String lastTxnBrands;
    @JsonProperty("DaysSinceLastTxn")
    public String daysSinceLastTxn;
    @JsonProperty("FirstPLCCPurchaseDate")
    public String firstPLCCPurchaseDate;
    @JsonProperty("LastPLCCPurchaseDate")
    public String lastPLCCPurchaseDate;
    @JsonProperty("PLCCNoTimesShopped")
    public String pLCCNoTimesShopped;
    @JsonProperty("RecencyDate")
    public String recencyDate;
    @JsonProperty("RecencyChannel")
    public String recencyChannel;
    @JsonProperty("RecencySource")
    public String recencySource;
    @JsonProperty("AcqDate")
    public String acqDate;
    @JsonProperty("AcqChannel")
    public String acqChannel;
    @JsonProperty("AcqSource")
    public String acqSource;
    @JsonProperty("AcqStore")
    public String acqStore;
    @JsonProperty("LifecycleGroup")
    public String lifecycleGroup;
    @JsonProperty("Customer12MoFlag")
    public String customer12MoFlag;
    @JsonProperty("StoreFreqCnt12Mo")
    public String storeFreqCnt12Mo;
    @JsonProperty("OnlineFreqCnt12Mo")
    public String onlineFreqCnt12Mo;
    @JsonProperty("StoreMaxSpendAmt12Mo")
    public String storeMaxSpendAmt12Mo;
    @JsonProperty("OnlineMaxSpendAmt12Mo")
    public String onlineMaxSpendAmt12Mo;
    @JsonProperty("AvgDaysBtwTxn12Mo")
    public String avgDaysBtwTxn12Mo;
    @JsonProperty("BOPISBOSSOrderCnt12Mo")
    public String bOPISBOSSOrderCnt12Mo;
    @JsonProperty("BOPISBOSSLastOrderDt12Mo")
    public String bOPISBOSSLastOrderDt12Mo;
    @JsonProperty("BuyerChannelStatus12Mo")
    public String buyerChannelStatus12Mo;
    @JsonProperty("BuyerBrandStoreFlag12Mo")
    public String buyerBrandStoreFlag12Mo;
    @JsonProperty("BuyerMallStoreFlag12Mo")
    public String buyerMallStoreFlag12Mo;
    @JsonProperty("BuyerOutletStoreFlag12Mo")
    public String buyerOutletStoreFlag12Mo;
    @JsonProperty("BOPISBOSSBuyer12Mo")
    public String bOPISBOSSBuyer12Mo;
    @JsonProperty("PrimarySMS")
    public String primarySMS;
    @JsonProperty("ClosestStore")
    public int closestStore;
    @JsonProperty("DistanceToClosestStore")
    public String distanceToClosestStore;
    @JsonProperty("ClosestCARStore")
    public String closestCARStore;
    @JsonProperty("DistanceToClosestCARStore")
    public String distanceToClosestCARStore;
    @JsonProperty("ClosestOKBStore")
    public String closestOKBStore;
    @JsonProperty("DistanceToClosestOKBStore")
    public String distanceToClosestOKBStore;
    @JsonProperty("ClosestCANCARStore")
    public String closestCANCARStore;
    @JsonProperty("DistanceToClosestCANCARStore")
    public String distanceToClosestCANCARStore;
    @JsonProperty("ClosestCANOKBStore")
    public String closestCANOKBStore;
    @JsonProperty("DistanceToClosestCANOKBStore")
    public String distanceToClosestCANOKBStore;
    @JsonProperty("StoreAffinity12")
    public String storeAffinity12;
    @JsonProperty("StoreAffinity24")
    public String storeAffinity24;
    @JsonProperty("TxnBrandAffinity")
    public String txnBrandAffinity;
    @JsonProperty("TxnAgeAffinity")
    public String txnAgeAffinity;
    @JsonProperty("TxnGenderAffinity")
    public String txnGenderAffinity;
    @JsonProperty("RFMSegment")
    public String rFMSegment;
    @JsonProperty("RFMRank")
    public String rFMRank;
    @JsonProperty("RFMGroup")
    public String rFMGroup;
    @JsonProperty("HeadOfHousehold")
    public String headOfHousehold;
    @JsonProperty("HeadOfHouseholdFlag")
    public String headOfHouseholdFlag;
    @JsonProperty("KidsInHH")
    public String kidsInHH;
    @JsonProperty("EMContactable")
    public String eMContactable;
    @JsonProperty("DMContactable")
    public String dMContactable;
    @JsonProperty("Promotability")
    public String promotability;
    @JsonProperty("TotalEmail")
    public String totalEmail;
    @JsonProperty("ProcessDate")
    public String processDate;
    @JsonProperty("TxnCntLast12Mo")
    public String txnCntLast12Mo;
    @JsonProperty("LifetimeTxnCnt")
    public int lifetimeTxnCnt;
    @JsonProperty("LifetimeTxnNetAmt")
    public String lifetimeTxnNetAmt;
    @JsonProperty("RewardsPointsBalance")
    public String rewardsPointsBalance;

    @Override
    public String VIEW_NAME() {
        return "D_Customer";
    }

    @Override
    public String TABLE_NAME() {
        return "CTRS-PE-Data-Customer";
    }
}
