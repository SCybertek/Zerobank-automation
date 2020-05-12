@payBills
Feature: Pay bills verify

  Scenario:
    Given user is on the login page
    When user logs in with valid credentials
    And User navigate to Pay Bills
    And User should verify that title is a "Zero - Pay Bills"
    Then User make payments
    And The payment was successfully submitted should be displayed
    And make a payment without entering the amount or date, Please fill out this field message! should be displayed




