Feature: Product Search on JioMart

  As a user
  I want to search for a specific product on JioMart
  So that I can verify that the search results display relevant items

  Scenario: Search for a product by brand and validate result titles
    Given the user launches the Edge browser and navigates to JioMart homepage
    When the user enters the product brand in the search bar
    And submits the search request
    Then the search results should contain product names
    And the product names should include the expected model keyword
    And any irrelevant product names should be reported in the console