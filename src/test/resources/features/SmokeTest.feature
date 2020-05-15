@smoke_test
Feature: Smoke test

  Scenario Outline: Go to <module> and verify title: <title>
    Given user is on the login page
    When user logs in with valid credentials
    And User navigate to "<tab>"
    And User should verify that title is a "<title>"

    Examples:
      | tab               |  title                    |
      | Account Activity  |  Zero - Account Activity  |
      | Account Summary   |  Zero - Account Summary   |
      | Pay Bills         |  Zero - Pay Bills         |
      | Online Statements |  Zero - Online Statements |