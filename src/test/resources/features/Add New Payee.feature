@addNew
Feature: Add new payee under pay bills
  Background:
    Given user is on the login page
    When user logs in with valid credentials

  Scenario: Add a new payee
    Given User navigate to Pay Bills
    Given Add New Payee tab
    And creates new payee using following information
      |Payee Name     | The Law Offices of Hyde, Price & Scharks|
      |Payee Address  | 100 Same st, Anytown, USA, 10001        |
      |Account        | Checking                                |
      |Payee details  | XYZ account                             |
    And click add button
  Then message The new payee The Law Office of Hyde,Price & Scharks was successfully created. should be displayed