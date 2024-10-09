package com.carters.steps;

import com.carters.utils.PropertyHelper;
import io.cucumber.java.en.Given;

public class TestSteps {
//PropertyHelper propertyHelper = new PropertyHelper();
    @Given("I access service")
    public void iAccessService() {
        System.out.println(PropertyHelper.getContainerUrl());
    }

}
