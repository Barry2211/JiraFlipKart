Feature: Adactin Login Functionality

  Scenario: Validating the Login using valid credentials
    Given User is on the login page
    When User enter the username and password
    |LifeHacker11		|A237F5				|
  	|weywefef				|qwerty				|
  	|TestCaseData 	|TestPassword	|
    And User clicks login button
    Then User should enter into HomePage

