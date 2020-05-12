package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StatementsAndDocumentsPageBase extends PageBase {

    @FindBy(linkText = "Online Statements")
    private WebElement onlineStatements;
    @FindBy(xpath = "//ul[@class='nav nav-pills']//li")
    private List<WebElement> displayedYear;


    public void onlineStatementsClick(){
        BrowserUtils.wait(3);
        onlineStatements.click();
        BrowserUtils.waitForPageToLoad(10);
    }
    public void selectYear(Integer int1){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+int1+"']"))).click();
    }
    public int numberStatementDisplayed(){
        List<WebElement> TotalRowsList = driver.findElements(By.xpath("//*[@id='os_2009']/table/tbody/tr/td[1]/a"));
        return TotalRowsList.size();
    }
    public List<String > displayedYears(){
        return BrowserUtils.getTextFromWebElements(displayedYear);
    }

    public void statementClick(String string){
        WebElement element=driver.findElement(By.xpath("//a[contains(text(),'"+string+"')]"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public String statementName(String string){
        BrowserUtils.waitForPageToLoad(4);
        WebElement element=driver.findElement(By.xpath("//a[text()='"+string+"']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public String fileNameAndType(String string){
        WebElement name = driver.findElement(By.xpath("//a[@href='/bank/online-statements-by-name.html?name=8534567-"+string+".pdf']"));
        return name.getText();
    }

}
