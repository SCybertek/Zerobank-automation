package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyPage  extends PageBase{

    @FindBy(linkText = "Purchase Foreign Currency")
    private WebElement purchaseForeign;
    @FindBy(id="pc_currency")
    private WebElement currency;
    @FindBy(id="pc_calculate_costs")
    private WebElement calculateButton;

    public void purchaseForeignClick(){
        BrowserUtils.wait(4);
        purchaseForeign.click();
    }
    public List<String> setCurrency(){
        BrowserUtils.wait(4);
        wait.until(ExpectedConditions.visibilityOf(currency));
        Select select=new Select(currency);
        List<WebElement>list=select.getOptions();
        return BrowserUtils.getTextFromWebElements(list);
    }
    public void calculateClick(){
        BrowserUtils.wait(4);
        calculateButton.click();
    }
    public String alert(){
        return driver.switchTo().alert().getText();
    }
}
