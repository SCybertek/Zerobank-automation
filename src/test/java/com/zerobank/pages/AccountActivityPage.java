package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountActivityPage extends PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//select[@id='aa_accountId']//option[1]")
    private WebElement defaultOptionSaving;
//    @FindBy(id = "account_activity_tab")
//    private WebElement accountActivity;

    @FindBy(xpath ="//div[@id='all_transactions_for_account']//th" )
    private List<WebElement>accountActivityTabNamesElements;
    @FindBy(xpath = "//select[@id='aa_accountId']//option")
    private List<WebElement> dropDownElements;

    public WebElement setDefaultOptionSaving(){
        BrowserUtils.wait(3);
        return defaultOptionSaving;
    }
    public List<String> accountActivityTabNames(){
        BrowserUtils.waitForPageToLoad(5);
        return BrowserUtils.getTextFromWebElements(accountActivityTabNamesElements);
    }
    public List<String> dropDown(){
        BrowserUtils.waitForPageToLoad(5);
        return BrowserUtils.getTextFromWebElements(dropDownElements);
    }

}
