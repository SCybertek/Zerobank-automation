@summary
Feature: Account summary verify

  Scenario:
    Given user is on the login page
    When user logs in with valid credentials
    Then User should verify that title is a "Zero - Account Summary"
    And following account types should be available
    | Cash Accounts       |
    | Investment Accounts |
    | Credit Accounts     |
    |Loan Accounts        |
    Then Credit Accounts table must have columns
    |Account    |
    |Credit Card|
    |Balance    |

