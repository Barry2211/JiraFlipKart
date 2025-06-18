Feature: Adactin Login Functionality

  Scenario: Validating the Login using valid credentials
    Given User is on the login page
    When User enter the username and password
    And User clicks login button
    Then User should enter into home

