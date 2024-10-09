package com.carters.utils;

import com.carters.entity.Customer;
import com.carters.entity.Email;
import org.json.JSONArray;

public class TestContext {

    public static boolean isWelcomeOfferFeatureCampaignRun = false;
    private String featureName;
    private String env;
    private String timestamp;
    private String scenarioName;
    private Customer customer;
    private Email email;
//    private Children children;
//    private OrderSummary order;
private JSONArray impressionResults;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public JSONArray getImpressionResults() {
        return impressionResults;
    }

    public void setImpressionResults(JSONArray impressionResults) {
        this.impressionResults = impressionResults;
    }
}
