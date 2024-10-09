package com.carters.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Children extends AbstractEntity{
    static {
        mandatoryFields = new String[]{"CustomerID", "ChildrenID","Age","BirthDay","BirthMonth",
                "BirthYear","FirstName"};
    }

    public Children(){}

    public Children(String number){
        this.childrenID = number;
    }

    public static Children DEFAULT()  {
        Children childern = null;
        try {
            //Load from default entity json file
            childern = getDefaultObject(Children.class);
        }catch (Exception e){
            //Do nothing
        }
        return childern;
    }
    @JsonProperty("CustomerID")
    public String customerID;
    @JsonProperty("ChildrenID")
    public String childrenID;
    @JsonProperty("Age")
    public int age;
    @JsonProperty("AgeCategory")
    public String ageCategory;
    @JsonProperty("ApparelSizeCaptureDate")
    public String apparelSizeCaptureDate;
    @JsonProperty("ApparelSize")
    public String apparelSize;
    @JsonProperty("BirthDay")
    public int birthDay;
    @JsonProperty("BirthMonth")
    public String birthMonth;
    @JsonProperty("BirthDate")
    public String birthDate;
    @JsonProperty("BirthYear")
    public int birthYear;
    @JsonProperty("CreatedDate")
    public String createdDate;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("MultiplesFivePlusFlag")
    public String multiplesFivePlusFlag;
    @JsonProperty("QuadrupletFlag")
    public String quadrupletFlag;
    @JsonProperty("RegistrationDate")
    public String registrationDate;
    @JsonProperty("SourceCd")
    public String sourceCd;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("TripletFlag")
    public String tripletFlag;
    @JsonProperty("TwinFlag")
    public String twinFlag;
    @JsonProperty("UpdatedDate")
    public String updatedDate;

    @Override
    public String VIEW_NAME() {
        return "D_Children";
    }

    @Override
    public String TABLE_NAME() {
        return "CTRS-PE-Data-Children";
    }
}