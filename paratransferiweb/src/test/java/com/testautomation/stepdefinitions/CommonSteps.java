package com.testautomation.stepdefinitions;

import com.testautomation.pages.BasePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import java.util.List;
import com.testautomation.utils.SelectorReader;

public class CommonSteps extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(CommonSteps.class);

    public CommonSteps() {
        super(); // BasePage constructor'ını çağır
    }

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

    @When("^\"([^\"]*)\" select boxindan \"([^\"]*)\" secilir$")
    public void selectBoxindanDegerSec(String locator, String value) {
        try {
            logger.info("Select box locator: {}, Value to select: {}", locator, value);
            String[] locatorParts = locator.split("\\.");
            waitForElementVisible(locatorParts[0], locatorParts[1]);
            WebElement element = findElement(locatorParts[0], locatorParts[1]);
            org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(element);
            
            // Mevcut seçenekleri logla
            select.getOptions().forEach(option -> 
                logger.info("Available option: {}", option.getText())
            );
            
            // Değer büyük harfle geldiyse küçük harfe çevirip deneyelim
            try {
                select.selectByVisibleText(value);
            } catch (Exception e) {
                select.selectByVisibleText(value.toLowerCase());
            }
        } catch (Exception e) {
            logger.error("Select box error for locator: {}, value: {}", locator, value, e);
            throw e;
        }
    }

    @Then("^\"([^\"]*)\" listesindeki son işlemin tutarı \"([^\"]*)\" olmalıdır$")
    public void checkLastTransactionAmount(String listLocator, String expectedAmount) {
        try {
            logger.info("Beklenen tutar: {}", expectedAmount);
            String[] locatorParts = listLocator.split("\\.");
            waitForElementVisible(locatorParts[0], locatorParts[1]);
            
            // Tüm elementleri bul ve son elemanı al
            List<WebElement> elements = findElements(locatorParts[0], locatorParts[1]);
            WebElement lastAmountElement = elements.get(elements.size() - 1);
            
            String actualAmount = lastAmountElement.getText().trim();
            actualAmount = actualAmount.replace("₺", "").replace(",", ".").trim();
            Assert.assertEquals("Transfer tutarı eşleşmiyor!", expectedAmount, actualAmount);
            logger.info("Transfer tutarı doğrulandı: {}", actualAmount);
        } catch (Exception e) {
            logger.error("Transfer tutarı kontrolünde hata: ", e);
            throw e;
        }
    }

    @Then("^\"([^\"]*)\" elementinin değeri \"([^\"]*)\" olmalıdır$")
    public void checkElementValue(String locator, String expectedValue) {
        try {
            logger.info("Element locator: {}, Expected value: {}", locator, expectedValue);
            String[] locatorParts = locator.split("\\.");
            waitForElementVisible(locatorParts[0], locatorParts[1]);
            WebElement element = findElement(locatorParts[0], locatorParts[1]);
            String actualValue = element.getText();
            
            Assert.assertEquals("Element değeri beklenen değere eşit değil!", expectedValue, actualValue);
            logger.info("Element değeri doğrulandı: {}", actualValue);
        } catch (Exception e) {
            logger.error("Element değeri kontrolünde hata: ", e);
            throw e;
        }
    }

    @Then("^\"([^\"]*)\" elementinin değeri \"([^\"]*)\" den farklı olmalıdır$")
    public void checkElementValueNotEquals(String locator, String unexpectedValue) {
        try {
            logger.info("Element locator: {}, Unexpected value: {}", locator, unexpectedValue);
            String[] locatorParts = locator.split("\\.");
            waitForElementVisible(locatorParts[0], locatorParts[1]);
            WebElement element = findElement(locatorParts[0], locatorParts[1]);
            String actualValue = element.getAttribute("value");
            
            Assert.assertNotEquals("Element değeri beklenmeyen değere eşit!", unexpectedValue, actualValue);
            logger.info("Element değeri doğrulandı (farklı): {}", actualValue);
        } catch (Exception e) {
            logger.error("Element değeri kontrolünde hata: ", e);
            throw e;
        }
    }

} 