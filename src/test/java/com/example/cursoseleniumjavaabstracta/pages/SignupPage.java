package com.example.cursoseleniumjavaabstracta.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignupPage extends BasePage {

    @FindBy(id = "sign-username")
    private WebElement usernameField;

    @FindBy(id = "sign-password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@id='signInModal']/div/div/div[3]/button[2]")
    private WebElement signupModalButton;

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step("Set username")
    public void setUsername(String baseUsername) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String uniqueUsername = baseUsername + timestamp;
        wait.until(ExpectedConditions.visibilityOf(usernameField)).clear();
        usernameField.sendKeys(uniqueUsername);
    }
    @Step("Set password")
    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }
    @Step("Click signup modal button")
    public void clickSignupModalButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupModalButton)).click();
    }

}
