package com.carters.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Email  extends AbstractEntity{
    static {
        mandatoryFields = new String[]{"EmailID","CustomerID","EmailAddress","HouseholdID","PrimaryEmail"};
    }

    public Email(String number){
        this.emailID = number;
    }

    public Email(){}

    public static Email DEFAULT()  {
        Email os = null;
        try {
            //Load from default entity json file
            os = getDefaultObject(Email.class);
        }catch (Exception e){
            //Do nothing
        }
        return os;
    }
    @JsonProperty("EmailID")
    public String emailID;
    @JsonProperty("CustomerID")
    public String customerID;
    @JsonProperty("AssignedStore")
    public String assignedStore;
    @JsonProperty("AvgEmailsPerMonth")
    public String avgEmailsPerMonth;
    @JsonProperty("BrandCode")
    public String brandCode;
    @JsonProperty("BUCountry")
    public String bUCountry;
    @JsonProperty("DMAEmailMktPanderFlg")
    public String dMAEmailMktPanderFlg;
    @JsonProperty("EmailMinCreateDate")
    public String emailMinCreateDate;
    @JsonProperty("EmailAddress")
    public String emailAddress;
    @JsonProperty("EmailDomain")
    public String emailDomain;
    @JsonProperty("LastClickedDate")
    public String lastClickedDate;
    @JsonProperty("LastOpenedDate")
    public String lastOpenedDate;
    @JsonProperty("LastPurchaseDate")
    public String lastPurchaseDate;
    @JsonProperty("LastSentDate")
    public String lastSentDate;
    @JsonProperty("ListID")
    public String listID;
    @JsonProperty("OptDownDate")
    public String optDownDate;
    @JsonProperty("OptDownFlag")
    public String optDownFlag;
    @JsonProperty("OptInFlag")
    public String optInFlag;
    @JsonProperty("OptInLanguage")
    public String optInLanguage;
    @JsonProperty("OriginalDate")
    public String originalDate;
    @JsonProperty("PrimaryEmailCustomer")
    public String primaryEmailCustomer;
    @JsonProperty("ProcessDate")
    public String processDate;
    @JsonProperty("SignedUpAt")
    public String signedUpAt;
    @JsonProperty("StatusDate")
    public String statusDate;
    @JsonProperty("StatusLanguageDate")
    public String statusLanguageDate;
    @JsonProperty("StatusSource")
    public String statusSource;
    @JsonProperty("UndeliverableDate")
    public String undeliverableDate;
    @JsonProperty("UndeliverableFlag")
    public String undeliverableFlag;
    @JsonProperty("UpdatedDate")
    public String updatedDate;
    @JsonProperty("ValidFormat")
    public String validFormat;
    @JsonProperty("LoyaltyID")
    public String loyaltyID;
    @JsonProperty("LoyaltyLastPurchaseDate")
    public String loyaltyLastPurchaseDate;
    @JsonProperty("LoyaltyFirstPurchaseDate")
    public String loyaltyFirstPurchaseDate;
    @JsonProperty("LoyaltyFirstName")
    public String loyaltyFirstName;
    @JsonProperty("LoyaltyLastName")
    public String loyaltyLastName;
    @JsonProperty("LastNotificationType")
    public String lastNotificationType;
    @JsonProperty("LoyaltyEnrollmentDate")
    public String loyaltyEnrollmentDate;
    @JsonProperty("LoyaltyDisenrollmentDate")
    public String loyaltyDisenrollmentDate;
    @JsonProperty("CurrentPointsBalance")
    public String currentPointsBalance;
    @JsonProperty("PointsUntilNextReward")
    public String pointsUntilNextReward;
    @JsonProperty("CurrentRewardBalance")
    public String currentRewardBalance;
    @JsonProperty("SpendUntilNextReward")
    public String spendUntilNextReward;
    @JsonProperty("RewardsTier")
    public String rewardsTier;
    @JsonProperty("PointsEarnedToDate")
    public String pointsEarnedToDate;
    @JsonProperty("RewardsEarnedToDate")
    public String rewardsEarnedToDate;
    @JsonProperty("RewardsUsedToDate")
    public String rewardsUsedToDate;
    @JsonProperty("RewardsActiveOfferFlag")
    public String rewardsActiveOfferFlag;
    @JsonProperty("LoyaltyStatus")
    public String loyaltyStatus;
    @JsonProperty("LoyaltyBrandAffinity")
    public String loyaltyBrandAffinity;
    @JsonProperty("BrandOfEnrollment")
    public String brandOfEnrollment;
    @JsonProperty("NextRewardExpirationDate")
    public String nextRewardExpirationDate;
    @JsonProperty("NextPointExpirationDate")
    public String nextPointExpirationDate;
    @JsonProperty("PointsIndicator")
    public String pointsIndicator;
    @JsonProperty("GhostLoyaltyID")
    public String ghostLoyaltyID;
    @JsonProperty("ETLBatchID")
    public String eTLBatchID;
    @JsonProperty("CreateDate")
    public String createDate;
    @JsonProperty("CreateUser")
    public String createUser;
    @JsonProperty("UpdateDate")
    public String updateDate;
    @JsonProperty("UpdateUser")
    public String updateUser;
    @JsonProperty("TierEffectiveDate")
    public String tierEffectiveDate;
    @JsonProperty("TierExpirationDate")
    public String tierExpirationDate;
    @JsonProperty("TierOverride")
    public String tierOverride;
    @JsonProperty("TierOverrideEffectiveDate")
    public String tierOverrideEffectiveDate;
    @JsonProperty("TierOverrideExpirationDate")
    public String tierOverrideExpirationDate;
    @JsonProperty("NextTierSpend")
    public String nextTierSpend;
    @JsonProperty("YTDSpend")
    public String yTDSpend;
    @JsonProperty("PLCCMemberStatus")
    public String pLCCMemberStatus;
    @JsonProperty("OverrideFlag")
    public String overrideFlag;
    @JsonProperty("ProfileCompletedFlag")
    public String profileCompletedFlag;
    @JsonProperty("AddressFlag")
    public String addressFlag;
    @JsonProperty("AddressFlagDate")
    public String addressFlagDate;
    @JsonProperty("ChildFlag")
    public String childFlag;
    @JsonProperty("ChildFlagDate")
    public String childFlagDate;
    @JsonProperty("SMSFlag")
    public String sMSFlag;
    @JsonProperty("SMSFlagDate")
    public String sMSFlagDate;
    @JsonProperty("AppPrefStore")
    public String appPrefStore;
    @JsonProperty("CustomerCreateDate")
    public String customerCreateDate;
    @JsonProperty("AppFirstLaunchDate")
    public String appFirstLaunchDate;
    @JsonProperty("PushNotificationStatusDate")
    public String pushNotificationStatusDate;
    @JsonProperty("PushNotificationOptIn")
    public String pushNotificationOptIn;
    @JsonProperty("LocationStatusDate")
    public String locationStatusDate;
    @JsonProperty("LocationOptIn")
    public String locationOptIn;
    @JsonProperty("AppDeviceType")
    public String appDeviceType;
    @JsonProperty("PushNotificationRegID")
    public String pushNotificationRegID;
    @JsonProperty("PushNotificationType")
    public String pushNotificationType;
    @JsonProperty("ReSignedUpDate")
    public String reSignedUpDate;
    @JsonProperty("HouseholdID")
    public String householdID;
    @JsonProperty("PrimaryEmail")
    public String primaryEmail;

    @Override
    public String VIEW_NAME() {
        return "D_Email";
    }

    @Override
    public String TABLE_NAME() {
        return "CTRS-PE-Data-Email";
    }
}
