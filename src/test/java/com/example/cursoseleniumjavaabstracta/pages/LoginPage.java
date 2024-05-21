package com.example.cursoseleniumjavaabstracta.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='logInModal']/div/div/div[3]/button[2]")
    private WebElement loginModalButton;

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    @FindBy(id = "nameofuser")
    private WebElement welcomeMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Set username")
    public void setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
        usernameField.sendKeys(username);
    }
    @Step("Set username: {username}")
    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }
    @Step("Click login modal button")
    public void clickLoginModalButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginModalButton)).click();
    }
    @Step("Accept alert")
    public void acceptAlert() {
        super.getAlertText();
    }
    @Step("Get welcome message")
    public String getWelcomeMessage() {
        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).getText();
    }
    @Step("Click logout button")
    public void clickLogoutButton() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
            logoutButton.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
            logoutButton.click();
        }
    }

    @Step("Get login button text")
    public String getLoginButtonText() {
        return wait.until(ExpectedConditions.visibilityOf(loginButton)).getText();
    }
}

