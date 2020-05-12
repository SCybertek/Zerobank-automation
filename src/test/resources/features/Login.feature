@login
  Feature: Login


    Background: open login page
      Given user is on the login page

      @positive_scenario
    Scenario:Login with valid username and password
      When user logs in with valid credentials
      Then User should verify that title is a "Account summary"

      @negative_scenario
    Scenario:Login with invalid username and password
      When User logs in with invalid credentials
      Then User should verify that error message "Login and/or password are wrong."

      @login3
    Scenario: Login with empty username and password
      When Users logs with blank username or password
      Then User should verify that error message "Login and/or password are wrong."
