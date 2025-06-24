package org.pages;

import java.util.List;

import org.baseclass.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartPOM extends DriverUtils{

	public FlipKartPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='Pke_EE']")
	private WebElement search;
	
	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//input[@class='zDPmFV']")
	private WebElement prodSearch;
	
	public WebElement getProdSearch() {
		return prodSearch;
	}
	
	@FindBy(xpath="//div[@class='KzDlHZ']")
	private List<WebElement> products;
	
	public List<WebElement> getProducts() {
		return products;
	}
}