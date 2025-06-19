package org.pages;

import org.baseclass.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverUtils{

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	public WebElement getUserName() {
		return userName;
	}
	
	@FindBy(id="password")
	private WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
}
