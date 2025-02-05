package com.testautomation.stepdefinitions;

import com.testautomation.pages.BasePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonSteps extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);
    
    @When("^\"([^\"]*)\" alanina \"([^\"]*)\" yazilir$")
    public void alanina_yazilir(String locator, String value) {
        try {
            logger.info("Locator: {}, Value: {}", locator, value);
            String[] locatorParts = locator.split("\\.");
            waitForElementVisible(locatorParts[0], locatorParts[1]);
            WebElement element = findElement(locatorParts[0], locatorParts[1]);
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            logger.error("Element not found or not interactable: {}", locator, e);
            throw e;
        }
    }
    
    @When("^\"([^\"]*)\" elementine tiklanir$")
    public void elementine_tiklanir(String locator) {
        try {
            logger.info("Clicking element with locator: {}", locator);
            String[] locatorParts = locator.split("\\.");
            waitForElementClickable(locatorParts[0], locatorParts[1]);
            findElement(locatorParts[0], locatorParts[1]).click();
        } catch (Exception e) {
            logger.error("Element not found or not clickable: {}", locator, e);
            throw e;
        }
    }
} 