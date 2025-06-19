package org.pages;

import java.util.List;

import org.baseclass.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JioMartPOM extends DriverUtils{

	public JioMartPOM() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='autocomplete-0-input']")
	private WebElement searchBar;
	
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	@FindBy(id="rel_pincode")
	private WebElement pinCode;
	
	public WebElement getPinCode() {
		return pinCode;
	}
	
	@FindBy(xpath="//div[@class='plp-card-details-name line-clamp jm-body-xs jm-fc-primary-grey-80']")
	private List<WebElement> productList;
	
	public List<WebElement> getProductList() {
		return productList;
	}
}
