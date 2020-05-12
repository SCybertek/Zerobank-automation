package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        System.out.println("Open login page");
        String URL = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        System.out.println("Login as a valid username and password");
        loginPage.login();
        BrowserUtils.wait(3);
    }
    @Then("User should verify that title is a {string}")
    public void userShouldVerifyThatTitleIsA(String title) {
        BrowserUtils.waitForPageToLoad(30);
        System.out.println(Driver.getDriver().getTitle());
        BrowserUtils.wait(3);
        Assert.assertEquals(title, Driver.getDriver().getTitle());
    }

    @When("User logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials() {
        System.out.println("Login as a invalid username and password");
        loginPage.login("user", "123");
        BrowserUtils.wait(3);
    }

    @When("Users logs with blank username or password")
    public void usersLogsWithBlankUsernameOrPassword() {
        System.out.println("Login as a blank username and password");
        loginPage.login("", "");
        BrowserUtils.wait(3);
    }

    @Then("User should verify that error message {string}")
    public void userShouldVerifyThatErrorMessage(String str) {
        str = "Login and/or password are wrong.";
        System.out.println("Verify that warning message Login and/or password are wrong.");
        BrowserUtils.waitForPageToLoad(5);
        BrowserUtils.wait(3);
        Assert.assertEquals(str,loginPage.getWarningMessage());

    }
}

