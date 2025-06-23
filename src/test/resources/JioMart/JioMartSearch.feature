Feature: Product Search on JioMart


  Scenario: Opening JioMart landing page
    Given the user launches the Edge browser and navigates to JioMart homepage "https://www.jiomart.com/"
    
	Scenario Outline: Search for a product by brand and validate result titles
		When the user enters the product brand "<Product Brand>" in the search bar
    And submits the search request
    Then the search results should contain product names
    And the product names should include the expected model keyword
    And any irrelevant product names should be reported in the console "<Product Name>"
    
    Examples:
    |Product Brand	|	Product Name	|
    |parle 					|	Biscut				|
    |parle					|	Poppins				|