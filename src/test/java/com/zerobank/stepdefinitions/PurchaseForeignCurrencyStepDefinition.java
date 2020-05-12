package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

public class PurchaseForeignCurrencyStepDefinition {
    PurchaseForeignCurrencyPage purchaseForeignCurrencyPage=new PurchaseForeignCurrencyPage();

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        purchaseForeignCurrencyPage.purchaseForeignClick();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
           for(String each: dataTable){
               purchaseForeignCurrencyPage.setCurrency().contains(each);
           }
    }
    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        purchaseForeignCurrencyPage.calculateClick();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",purchaseForeignCurrencyPage.alert());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        purchaseForeignCurrencyPage.calculateClick();
    }
}
