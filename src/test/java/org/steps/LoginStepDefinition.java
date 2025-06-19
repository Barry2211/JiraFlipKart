package org.steps;

import org.baseclass.DriverUtils;
import org.baseclass.MethodUtils;
import org.pages.LoginPage;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends DriverUtils{

	LoginPage log = new LoginPage();
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    driverInit(MethodUtils.EDGE);
	    urlInit("https://adactinhotelapp.com/");
	}
	@When("User enter the username and password")
	public void user_enter_the_username_and_password() {
		log=new LoginPage();
	    log.getUserName().sendKeys("LifeHacker11");
	    log.getPassword().sendKeys("A237F5");
	}
	@When("User clicks login button")
	public void user_clicks_login_button() {
		locate(MethodUtils.id, "login").click();
	}
	
	@Then("User should enter into HomePage")
	public void user_should_enter_into_home_page() {
	   String title = driver.getTitle();
	   org.junit.Assert.assertEquals("Home page executed","Adactin.com - Search Hotel", title);
	   System.out.println(title);
	}



}
