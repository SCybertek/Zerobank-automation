package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionPageBase;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FindTransactionsStepDefinition {
    FindTransactionPageBase findTransactionPageBase=new FindTransactionPageBase();
    WebDriverWait wait;
    WebDriver driver;

    @When("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        BrowserUtils.wait(4);
        findTransactionPageBase.findTransactionClick();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
        BrowserUtils.wait(4);
        findTransactionPageBase.dateSetUp(from,to);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.wait(4);
        findTransactionPageBase.searchClick().click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String start, String end) {
        BrowserUtils.wait(4);
        List<String> list=findTransactionPageBase.getResultDate();
        for (String str: list){
            Assert.assertTrue((str.compareTo(start) >= 0 && str.compareTo(end) <= 0));
        }
        //second way------ with converting to date
//        List<LocalDate> dateList = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        //create a date list from strings
//        for(String str: list){
//            LocalDate date = LocalDate.parse(str, formatter);
//            dateList.add(date);
//        }
        //convert start and end dates to date from string
//        LocalDate startDate = LocalDate.parse(start, formatter);
//        LocalDate endDate = LocalDate.parse(end, formatter);

        //assert each date in the list is in between start date and end date
//        for (LocalDate date: dateList){
//            Assert.assertEquals((date.compareTo(startDate)>=0 && date.compareTo(endDate)<=0),true);
//        }
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
            List<String> list=findTransactionPageBase.getResultDate();
            List<LocalDate> dateList = new ArrayList<>();

            for(String str: list){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(str, formatter);
                dateList.add(date);
            }
            List<LocalDate> sortedList = new ArrayList<>();
            sortedList.addAll(dateList);
            sortedList.sort(Collections.reverseOrder());
            Assert.assertEquals("Already sorted",dateList,sortedList);
    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        BrowserUtils.wait(4);
     List<String> list=findTransactionPageBase.getResultDate();
        Assert.assertFalse(list.contains(string));
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        BrowserUtils.wait(4);
        findTransactionPageBase.descriptionClick(string);
    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        BrowserUtils.wait(4);
        List<String> list = findTransactionPageBase.descriptionOnlineResult();
        System.out.println("list = " + list);
        for (String each : list) {
            Assert.assertTrue(each.contains(string));
        }
    }
    @When("user selects type {string}")
    public void user_selects_type(String string) {
        BrowserUtils.wait(4);
//       // findTransactionPageBase.dropDownClicked(string).click();"
//        wait.until(ExpectedConditions.visibilityOf(findTransactionPageBase.dropDownClicked(string)));
//        findTransactionPageBase.dropDownClicked(string).click();
        findTransactionPageBase.selectType(string);
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.wait(4);
        List<WebElement>list=findTransactionPageBase.getDepositResult();
        for(WebElement each: list){
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.wait(4);
        List<WebElement>list=findTransactionPageBase.getWithdrawalResult();
        for(WebElement each: list){
            Assert.assertTrue(each.isDisplayed());
        }
    }
    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtils.wait(4);
        List<WebElement> list = findTransactionPageBase.getWithdrawalResult();
        for(WebElement each:list ){
            Assert.assertTrue(each.isDisplayed());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        BrowserUtils.wait(4);
        List<WebElement> list = findTransactionPageBase.getDepositResult();
        for(WebElement each:list ){
            Assert.assertTrue(each.isDisplayed());}
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        BrowserUtils.wait(4);
        List<String> list = findTransactionPageBase.descriptionOnlineResult();
        System.out.println("list = " + list);
        for (String each : list) {
            Assert.assertFalse(each.contains(string));
        }
    }

}

