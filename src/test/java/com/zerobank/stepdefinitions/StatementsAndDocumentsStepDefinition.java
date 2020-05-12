package com.zerobank.stepdefinitions;

import com.zerobank.pages.StatementsAndDocumentsPageBase;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocumentsStepDefinition {
    StatementsAndDocumentsPageBase statementsAndDocumentsPageBase=new StatementsAndDocumentsPageBase();
    @Given("User navigate to Online Statements")
    public void user_navigate_to_Online_Statements() {
        statementsAndDocumentsPageBase.onlineStatementsClick();
        BrowserUtils.wait(4);
    }
    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals("Zero - Online Statements",Driver.getDriver().getTitle());
    }
    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer int1) {
        statementsAndDocumentsPageBase.selectYear(int1);
    }
    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(int count) {
        BrowserUtils.wait(4);
        Assert.assertEquals(statementsAndDocumentsPageBase.numberStatementDisplayed(),count);
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String string) {
        statementsAndDocumentsPageBase.statementClick(string);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        Assert.assertTrue(statementsAndDocumentsPageBase.statementName(string).contains(string));
    }
    @Then("the {string} file type should be pdf")
    public void the_file_type_should_be_pdf(String string) {
        Assert.assertTrue(statementsAndDocumentsPageBase.fileNameAndType(string).contains(string));
    }


}
