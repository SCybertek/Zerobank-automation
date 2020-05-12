package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountSummaryDefinition {

    AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    WebDriverWait wait;

    @And("following account types should be available")
    public void following_account_types_should_be_available(List<String> dataTable) {
        System.out.println("Expected Types: " + dataTable);
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        Assert.assertEquals(dataTable,accountSummaryPage.getAccountSummaryTypes());
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> columns) {
        System.out.println("Expceted columns: "+columns);
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        Assert.assertEquals(columns,accountSummaryPage.getCreditAccountsColumns());
    }

}
