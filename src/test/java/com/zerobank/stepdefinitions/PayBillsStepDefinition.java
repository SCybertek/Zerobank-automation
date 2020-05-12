package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayBillsStepDefinition {

    PayBillsPage payBillsPage=new PayBillsPage();
    WebDriverWait wait;
    WebDriver driver;

    @When("User navigate to Pay Bills")
    public void user_navigate_to_Pay_Bills() {
        BrowserUtils.wait(4);
        payBillsPage.payBillsNavigate();
    }

    @Then("User make payments")
    public void user_make_payments() {
        BrowserUtils.wait(4);
        payBillsPage.makePayments("200","2020-06-20","credit card payment");
    }

    @Then("The payment was successfully submitted should be displayed")
    public void the_payment_was_successfully_submitted_should_be_displayed() {
        BrowserUtils.wait(4);
        Assert.assertTrue(payBillsPage.getSuccesfullMessage().isDisplayed());
    }
    @Then("make a payment without entering the amount or date, Please fill out this field message! should be displayed")
    public void make_a_payment_without_entering_the_amount_or_date_Please_fill_out_this_field_message_should_be_displayed() {
        BrowserUtils.wait(4);
        payBillsPage.makePayments("","","credit card payment");
        BrowserUtils.wait(4);
        Assert.assertEquals(payBillsPage.alertMessage(),"Please fill out this field.");
    }


}
