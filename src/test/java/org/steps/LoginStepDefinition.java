package org.steps;

import org.baseclass.DriverUtils;
import org.baseclass.MethodUtils;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends DriverUtils{

	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
	    driverInit(MethodUtils.EDGE);
	    urlInit("https://adactinhotelapp.com/");
	}
	@When("User enter the username and password")
	public void user_enter_the_username_and_password() {
	    locate(MethodUtils.id, "username").sendKeys("qwerty@gmail.com");
	    locate(MethodUtils.id, "password").sendKeys("asdfghjk");
	}
	@When("User clicks login button")
	public void user_clicks_login_button() {
		locate(MethodUtils.id, "login").click();;
	}
	@Then("User should enter into home")
	public void user_should_enter_into_home() {
	    String title = driver.getTitle();
	    Assert.assertEquals(title, "HomePage", "HomePage came");
	}



}
