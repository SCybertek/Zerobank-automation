package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends PageBase {

    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsInput;
    @FindBy(xpath = "//div[@id='alert_content']//span")
    private WebElement succesfullMessage;
    @FindBy(xpath = "//select[@id='sp_payee']//option[2]")
    private WebElement payeeInput;
    @FindBy(xpath = "//select[@id='sp_account']//option[1]")
    private WebElement accountInput;
    @FindBy(id = "sp_amount")
    private WebElement amountInput;
    @FindBy(id="sp_date")
    private WebElement dateInput;
    @FindBy(id = "sp_description")
    private WebElement descriptionInput;
    @FindBy(id = "pay_saved_payees")
    private WebElement payInput;


    public void payBillsNavigate(){
        BrowserUtils.waitForPageToLoad(6);
        BrowserUtils.wait(4);
        payBillsInput.click();
    }

    public void makePayments(String amount, String date,String description){
        BrowserUtils.waitForPageToLoad(10);
        payeeInput.click();
        accountInput.click();
        amountInput.sendKeys(amount);
        dateInput.sendKeys(date);
        descriptionInput.sendKeys(description);
        payInput.click();
    }
    public WebElement getSuccesfullMessage(){
        BrowserUtils.waitForPageToLoad(8);
        return succesfullMessage;
    }
    public void getAlertlMessage(){
        BrowserUtils.waitForPageToLoad(8);
    }
    public String alertMessage(){
        String message = driver.findElement(By.id("sp_amount")).getAttribute("validationMessage");
        return  message;
    }
}
