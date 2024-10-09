package com.carters.steps;

import com.carters.actions.Impression;
import com.carters.entity.Customer;
import com.carters.entity.CustomerHelper;
import com.carters.entity.Email;
import com.carters.entity.EmailHelper;
import com.carters.functions.InteractionHistory;
import com.carters.utils.NumberGenerator;
import com.carters.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonSteps {

    private static Logger logger;
    private TestContext context;

    public CommonSteps(TestContext context) {
        this.context = context;
        logger = LogManager.getLogger("CommonSteps");
    }

    private static final NumberGenerator generator = NumberGenerator.getInstance();
    @Given("Generate Customer")
    public void generateCustomer(DataTable table) throws Exception {
        synchronized (generator) {
            String number = generator.generateUniqueNumber();
            Customer customer = CustomerHelper.insertCustomer(table, number);
            context.setCustomer(customer);
        }
    }

    @Given("Create email for Customer")
    public void createEmail() throws Exception {
        synchronized (generator) {
            String number = generator.generateUniqueNumber();
            Email email = EmailHelper.insertEmail(number, context.getCustomer().customerID);
            context.setEmail(email);
        }
    }

    @And("Create a new {string} Impression")
    public void createImpression(String channel) throws Exception {
        JSONArray results = Impression.createImpression(Impression.CHANNEL.valueOf(channel), context.getEmail().emailAddress);
        context.setImpressionResults(results);
    }

    @Then("Check IH if action is served")
    public void checkIHForActionServed(List<String> values) throws InterruptedException {
        boolean result = checkIH(values, context.getCustomer().customerID);
        assertEquals(result, true);
    }

    @Then("Check IH if action is not served")
    public void checkIHForActionNotServed(List<String> values) {
        boolean result = checkIH(values, context.getCustomer().customerID);
        assertEquals(result, false);
    }

    private boolean checkIH(List<String> values, String customerID) {
        ResponseBody res = InteractionHistory.getIHResultsForCustomer(customerID);
        boolean result = false;
        try {
            JSONArray offerHistory = new JSONObject(res.print()).getJSONArray("OfferHistory");
            Iterator itr = offerHistory.iterator();

            while (itr.hasNext()) {
                JSONObject obj = (JSONObject) itr.next();
                String name = (String) obj.get("Name");
                if (values.contains(name)) {
                    result = true;
                    break;
                }
            }
        } catch (Exception error) {
            logger.error("Error while fetching interaction history for customer " + customerID, error.getMessage());
            result = false;
        }
        return result;
    }
}
