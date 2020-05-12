package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class FindTransactionPageBase  extends PageBase{

    protected WebDriver driver;

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransaction;
    @FindBy(id="aa_fromDate")
    private WebElement dateFrom;
    @FindBy(id="aa_toDate")
    private WebElement dateTo;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement search;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//td[1]")
    private List<WebElement> resultDate;
    @FindBy(name="description")
    private WebElement description;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[2]")
    private  List<WebElement> descriptionOnline;
    @FindBy(xpath = "//select[@id='aa_type']//option")
    private List<WebElement> dropDown;
    @FindBy(id="aa_type")
    private WebElement type;
    //th[text()='Withdrawal']//../../following-sibling::tbody//td[3]
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[3]")
    private List<WebElement> depositResult;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//td[4]")
    private List<WebElement> withdrawalResult;



    public  void findTransactionClick(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(findTransaction)).click();
    }
    public  void dateSetUp(String from, String to){
        BrowserUtils.waitForPageToLoad(10);
        dateFrom.clear();
        wait.until(ExpectedConditions.visibilityOf(dateFrom)).click();
        dateFrom.sendKeys(from);
        dateTo.clear();
        wait.until(ExpectedConditions.visibilityOf(dateTo)).click();
        dateTo.sendKeys(to);
    }
    public WebElement searchClick(){
        BrowserUtils.waitForPageToLoad(10);
      //  wait.until(ExpectedConditions.visibilityOf(search));
        return search;
    }
    public List<String> getResultDate (){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@id='filtered_transactions_for_account']//tbody//td[1])[1]")));
        BrowserUtils.wait(4);
        return BrowserUtils.getTextFromWebElements(resultDate);
    }
    public void descriptionClick(String str){
        BrowserUtils.wait(4);
        description.click();
        description.clear();
        description.sendKeys(str);
    }
    public List<String> descriptionOnlineResult (){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(4);
        return BrowserUtils.getTextFromWebElements(descriptionOnline);
    }
    public WebElement depositDisplayed(){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(4);
        return description;
    }
    public List<WebElement> dropDownDisplayed(){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(4);
        return dropDown;
    }
    public void selectType(String string){
        BrowserUtils.wait(3);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("aa_type"))));
        Select select = new Select(type);
        searchClick();
}
    public List<WebElement> getDepositResult(){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(4);
        return depositResult;
    }
    public List<WebElement> getWithdrawalResult(){
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(4);
        return withdrawalResult;
    }



}
