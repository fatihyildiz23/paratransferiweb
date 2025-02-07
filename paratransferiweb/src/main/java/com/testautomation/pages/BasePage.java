package com.testautomation.pages;

import com.testautomation.driver.DriverManager;
import com.testautomation.utils.SelectorReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    protected WebElement findElement(String page, String elementName) {
        return driver.findElement(SelectorReader.getLocator(page, elementName));
    }
    
    protected void waitForElementVisible(String page, String elementName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            SelectorReader.getLocator(page, elementName)));
    }
    
    protected void waitForElementClickable(String page, String elementName) {
        wait.until(ExpectedConditions.elementToBeClickable(
            SelectorReader.getLocator(page, elementName)));
    }





    protected List<WebElement> findElements(String page, String key) {

        return driver.findElements(SelectorReader.getLocator(page, key));

    }

}
