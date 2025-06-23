package org.steps;

import java.util.ArrayList;
import java.util.List;

import org.baseclass.DriverUtils;
import org.baseclass.MethodUtils;
import org.baseclass.ProductModels;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.pages.JioMartPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JioMartProductSearch extends DriverUtils{
	public JioMartPOM jioPOM;
	List<WebElement> productList=new ArrayList<>();
	@Given("the user launches the Edge browser and navigates to JioMart homepage {string}")
	public void the_user_launches_the_edge_browser_and_navigates_to_jio_mart_homepage(String url) {
		driverInit(MethodUtils.EDGE);
		urlInit(url);
		driverWait(5);
		windowOp(MethodUtils.max);
		jioPOM = new JioMartPOM();
		jioPOM.getPinCode().sendKeys("600043",Keys.ENTER);
	}
	@When("the user enters the product brand {string} in the search bar")
	public void the_user_enters_the_product_brand_in_the_search_bar(String brand) {
		jioPOM = new JioMartPOM();
		
		jioPOM.getSearchBar().sendKeys(Keys.chord(Keys.CONTROL,"a"),brand);
	}
	@When("submits the search request")
	public void submits_the_search_request() {
		jioPOM = new JioMartPOM();
		jioPOM.getSearchBar().submit();
	}
	@Then("the search results should contain product names")
	public void the_search_results_should_contain_product_names() {
		jioPOM = new JioMartPOM();
		productList=jioPOM.getProductList();
	}
	@Then("the product names should include the expected model keyword")
	public void the_product_names_should_include_the_expected_model_keyword() {
	    for(WebElement prod:productList) {
	    	System.out.println(prod.getText());
	    }
	}
	@Then("any irrelevant product names should be reported in the console {string}")
	public void any_irrelevant_product_names_should_be_reported_in_the_console(String product) {
		 for(WebElement prod:productList) {
		    	String text = prod.getText();
		    	if(!text.contains(product)) {
		    		System.out.println("Irrelavent product for "+product+": "+text);
		    	}
		    }
	}
	
}
