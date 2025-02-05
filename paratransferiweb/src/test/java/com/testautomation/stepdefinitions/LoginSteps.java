package com.testautomation.stepdefinitions;

import com.testautomation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class LoginSteps {
    
    private final LoginPage loginPage;
    
    public LoginSteps() {
        loginPage = new LoginPage();
    }
    
    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.navigateToLoginPage();
    }
    
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }
    
    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue("Login was not successful", loginPage.isLoginSuccessful());
    }
    
    @And("sistem {string} saniye bekler")
    public void sistem_saniye_bekler(String saniye) {
        try {
            Thread.sleep(Integer.parseInt(saniye) * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
} 