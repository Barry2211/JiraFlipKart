package org.steps;

import java.util.List;

import org.baseclass.DriverUtils;
import org.baseclass.MethodUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.pages.FlipKartPOM;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipKartProduct extends DriverUtils{
	FlipKartPOM flip;

	@Given("the user launches the Edge browser and navigates to FlipKart homepage {string}")
	public void ApplicationLaunch(String url) {
		driverInit(MethodUtils.EDGE);
		urlInit(url);
		driverWait(5);
		windowOp(MethodUtils.max);
	}
	@When("the user enters the product brand in the search bar and submits the search request")
	public void ProductSearch(DataTable table) {
	    List<String> data = table.asList();
	    flip = new FlipKartPOM();
	    WebElement search = flip.getSearch();
	    String product = data.get(2);
	    search.sendKeys(product);
	    search.submit();
	}
	
	@When("the user enters the product brand and model in the search bar and submits the search request")
	public void BrandProductSearch(DataTable table) {
	    List<List<String>> data = table.asLists();
	    flip = new FlipKartPOM();
	    WebElement search = flip.getProdSearch();
	    List<String> Prodlist = data.get(2);
	    search.sendKeys(Keys.chord(Keys.CONTROL,"a"),Prodlist.get(0),Prodlist.get(1));
	    search.submit();
	}
	
	@Then("the search results should contain products")
	public void ResultPage() {
		flip = new FlipKartPOM();
		List<WebElement> products = flip.getProducts();
		for(WebElement element:products) {
			System.out.println(element.getText());
		}
	}
}
