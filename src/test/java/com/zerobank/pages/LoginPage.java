package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase{

    @FindBy(id = "signin_button")
    private WebElement signingButton;

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(name = "submit")
    private WebElement submit;

    @FindBy(xpath="//div[@class='alert alert-error']")
    private WebElement warningMessage;

    @FindBy(linkText = "Forgot your password ?")
    private WebElement forgotPassword;

    public String getWarningMessage(){
        BrowserUtils.waitForPageToLoad(6);
        wait.until(ExpectedConditions.visibilityOf(warningMessage));
        BrowserUtils.wait(4);
        return warningMessage.getText().trim();

    }

    public void login(String usernameValue, String passwordValue){
        wait.until(ExpectedConditions.visibilityOf(signingButton)).click();
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue,Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

    public void login(){
        wait.until(ExpectedConditions.visibilityOf(signingButton)).click();
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitForPageToLoad(3);
    }
}
