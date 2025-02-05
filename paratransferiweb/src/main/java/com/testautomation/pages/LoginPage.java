package com.testautomation.pages;

import com.testautomation.utils.SelectorReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
    private static final String PAGE = "loginPage";
    
    @FindBy(css = "#{SelectorReader.getSelector('loginPage', 'usernameInput')}")
    private WebElement usernameInput;
    
    @FindBy(css = "#{SelectorReader.getSelector('loginPage', 'passwordInput')}")
    private WebElement passwordInput;
    
    @FindBy(xpath = "#{SelectorReader.getSelector('loginPage', 'loginButton')}")
    private WebElement loginButton;
    
    @FindBy(css = "#{SelectorReader.getSelector('loginPage', 'successMessage')}")
    private WebElement successMessage;
    
    public void navigateToLoginPage() {
        driver.get("http://catchylabs-webclient.testinium.com/signIn");
    }
    
    public void enterUsername(String username) {
        waitForElementVisible(PAGE, "usernameInput");
        WebElement element = findElement(PAGE, "usernameInput");
        element.clear();
        element.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        waitForElementVisible(PAGE, "passwordInput");
        WebElement element = findElement(PAGE, "passwordInput");
        element.clear();
        element.sendKeys(password);
    }
    
    public void clickLoginButton() {
        waitForElementClickable(PAGE, "loginButton");
        findElement(PAGE, "loginButton").click();
    }
    
    public void clickCallHelloWorldButton() {
        waitForElementClickable(PAGE, "callHelloWorldButton");
        findElement(PAGE, "callHelloWorldButton").click();
    }
    
    public void clickDokumaTipi() {
        waitForElementClickable(PAGE, "dokumaTipi");
        findElement(PAGE, "dokumaTipi").click();
    }
    
    public void selectDokumaTipiOption() {
        waitForElementClickable(PAGE, "dokumaTipiSec");
        findElement(PAGE, "dokumaTipiSec").click();
    }
    
    public boolean isLoginSuccessful() {
        WebElement successMessage = findElement("loginPage", "successMessage");
        waitForElementVisible(successMessage);
        return successMessage.isDisplayed();
    }

    private void waitForElementVisible(WebElement successMessage) {
    }
} 