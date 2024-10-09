package com.carters.steps;

import com.carters.entity.Customer;
import com.carters.entity.CustomerHelper;
import com.carters.utils.NumberGenerator;
import com.carters.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class CoreplccSteps {
    private static final NumberGenerator generator = NumberGenerator.getInstance();

//    @Given("Generate Customer")
//    public void generateCustomer(DataTable table) throws Exception {
//            synchronized (generator) {
//                String number = generator.generateUniqueNumber();
//                Customer customer = CustomerHelper.insertCustomer(table, number);
////            context.setCustomer(customer);
//            }
//        }
//

}
