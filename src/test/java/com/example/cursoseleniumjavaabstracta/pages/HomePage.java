package com.example.cursoseleniumjavaabstracta.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "signin2")
    private WebElement signupButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Step("Click login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }
    @Step("Click signup button")
    public SignupPage clickSignupButton() {
        signupButton.click();
        return new SignupPage(driver);
    }
}
