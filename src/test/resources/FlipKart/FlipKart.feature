Feature: FlipKart Search function

  @tag1
  Scenario: To check the product search functionality
  	Given the user launches the Edge browser and navigates to FlipKart homepage "https://www.flipkart.com/"
  	When the user enters the product brand in the search bar and submits the search request
  	|Laptop	|
  	|Phone	|
  	|TV			|
  	And the user enters the product brand and model in the search bar and submits the search request
  	|Lenovo		|Laptop	|
  	|Apple		|Phone	|
  	|Panasonic|TV			|
    Then the search results should contain products
   

