@activity
Feature: Account activity verify

  Scenario:
    Given user is on the login page
    When user logs in with valid credentials
    And User navigate to Account Activity
    And User should verify that title is a "Zero - Account Activity"
    Then Account drop down default option should be Savings
    And following account drop down should be available
      |Savings     |
      |Checking    |
      |Savings     |
      |Loan        |
      |Credit Card |
      |Brokerage   |
    And Transactions table should have column
      |Date        |
      |Description |
      |Deposit     |
      |Withdrawal  |