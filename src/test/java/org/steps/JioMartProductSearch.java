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
	ProductModels product = new ProductModels("parle g", "Hearphones");
	@Given("the user launches the Edge browser and navigates to JioMart homepage")
	public void the_user_launches_the_edge_browser_and_navigates_to_jio_mart_homepage() {
		driverInit(MethodUtils.EDGE);
		urlInit("https://www.jiomart.com/");
		driverWait(5);
		windowOp(MethodUtils.max);
		jioPOM = new JioMartPOM();
		jioPOM.getPinCode().sendKeys("600043",Keys.ENTER);
	}
	@When("the user enters the product brand in the search bar")
	public void the_user_enters_the_product_brand_in_the_search_bar() {
		jioPOM = new JioMartPOM();
		jioPOM.getSearchBar().sendKeys(product.brand);
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
		System.out.println(productList.size());
	}
	@Then("the product names should include the expected model keyword")
	public void the_product_names_should_include_the_expected_model_keyword() {
	    for(WebElement prod:productList) {
	    	System.out.println(prod.getText());
	    }
	}
	@Then("any irrelevant product names should be reported in the console")
	public void any_irrelevant_product_names_should_be_reported_in_the_console() {
		 for(WebElement prod:productList) {
		    	String text = prod.getText();
		    	if(text.contains(product.brand)) {
		    		System.out.println("Invalid: "+text);
		    	}
		    }
	}
	
}
