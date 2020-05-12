package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddNewPayeePageBase;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Map;

public class AddNewPayeeStepDefiniton {
    AddNewPayeePageBase addNewPayeePageBase=new AddNewPayeePageBase();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
    addNewPayeePageBase.addNewPAyeeClick();
    }
    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        BrowserUtils.wait(4);
        addNewPayeePageBase.addNewPayeeInformation(dataTable.get("Payee Name"),dataTable.get("Payee Address"),
                dataTable.get("Account"),dataTable.get("Payee details"));
    }
    @Given("click add button")
    public void click_add_button() {
        addNewPayeePageBase.addButtonClick();
    }
    @Then("message The new payee The Law Office of Hyde,Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Office_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        BrowserUtils.wait(5);
        String message="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals(message,addNewPayeePageBase.message());
    }

}
