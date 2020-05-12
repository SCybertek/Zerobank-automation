
@navigation
    Feature: Navigating to specific accounts in Accounts Activity

  Background:
  Given user is on the login page
  When user logs in with valid credentials

    Scenario: Savings account redirect
      When the user clicks on Savings link on the Account Summary page
      Then User should verify that title is a "Zero - Account Activity"
      And Account drop down should have "Savings" selected

    Scenario: Brokerage account redirect
      When the user clicks on "Brokerage" link on the Account Summary page
      Then User should verify that title is a "Zero - Account Activity"
      And Account drop down should have "Brokerage" selected

    Scenario: Checking account redirect Given the user is logged in
      When the user clicks on "Checking" link on the Account Summary page
      Then User should verify that title is a "Zero - Account Activity"
      And Account drop down should have "Checking" selected

    Scenario: Credit Card account redirect Given the user is logged in
      When the user clicks on "Credit Card" link on the Account Summary page
      Then User should verify that title is a "Zero - Account Activity"
      And Account drop down should have "Credit Card" selected

    Scenario: Loan account redirect Given the user is logged in
      When the user clicks on "Loan" link on the Account Summary page
      Then User should verify that title is a "Zero - Account Activity"
      And Account drop down should have "Loan" selected