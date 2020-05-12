package com.zerobank.pages;


import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    protected WebDriver driver= Driver.getDriver();
    protected WebDriverWait wait=new WebDriverWait(driver,30);

    @FindBy(className = "icon-user")
    protected WebElement currentUser;


    public PageBase(){
        PageFactory.initElements(driver,this);
    }

    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    public void navigateTo(String tabName){
        String tabNameXpath="//a[text()='"+tabName+"']";    ////li[@id='account_summary_tab']//a[text()='Account Summary']

       driver.findElement(By.xpath(tabNameXpath)).click();
        BrowserUtils.wait(4);
    }

}
