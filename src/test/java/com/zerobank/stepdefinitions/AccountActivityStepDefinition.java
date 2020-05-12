package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountActivityStepDefinition {
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    WebDriverWait wait;

    @Then("Account drop down default option should be Savings")
    public void account_drop_down_default_option_should_be_Savings() {
        BrowserUtils.wait(3);
       Assert.assertTrue(accountActivityPage.setDefaultOptionSaving().isSelected());
    }
    @Then("Transactions table should have column")
    public void transactions_table_should_have_column(List<String>column) {
        System.out.println("Expected: "+column);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
        Assert.assertEquals(column,accountActivityPage.accountActivityTabNames());
    }

     @When("User navigate to Account Activity")
     public void user_navigate_to_Account_Activity() {
         BrowserUtils.wait(4);
         accountActivityPage.accountActivityClick();
}

    @Then("following account drop down should be available")
    public void following_account_drop_down_should_be_available(List<String> dropDown) {
        System.out.println("Expected : "+dropDown);
       BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
        Assert.assertEquals(dropDown,accountActivityPage.dropDown());

    }


}
