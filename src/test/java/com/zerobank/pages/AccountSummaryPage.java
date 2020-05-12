package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AccountSummaryPage  extends PageBase {
    protected WebDriverWait wait;
    protected WebDriver driver;

    @FindBy(tagName = "h2")
    private static List<WebElement> accountSummaryTypes;
    @FindBy(xpath = "//h2[text()='Credit Accounts'] //following-sibling::div[1]//tr[1]//th")
    private List<WebElement> creditAccountsColumns;


    public List<String> getCreditAccountsColumns() {
        BrowserUtils.waitForPageToLoad(10);
        return BrowserUtils.getTextFromWebElements(creditAccountsColumns);
  }
    public List<String> getAccountSummaryTypes() {
        BrowserUtils.waitForPageToLoad(10);
        return BrowserUtils.getTextFromWebElements(accountSummaryTypes);
    }
}

