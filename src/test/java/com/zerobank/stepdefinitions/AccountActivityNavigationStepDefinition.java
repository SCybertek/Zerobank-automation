package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityNavigationPageBase;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivityNavigationStepDefinition {

    AccountActivityNavigationPageBase accountActivityNavigationPageBase = new AccountActivityNavigationPageBase();
    WebDriverWait wait;

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
       BrowserUtils.wait(4);
       accountActivityNavigationPageBase.savingClicked().click();
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        BrowserUtils.wait(4);
        accountActivityNavigationPageBase.clickTo(string);
    }
    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String string) {
        BrowserUtils.wait(4);
        Assert.assertTrue(accountActivityNavigationPageBase.clickLink(string).isSelected());

    }

}
