package com.example.cursoseleniumjavaabstracta.scripts;

import com.example.cursoseleniumjavaabstracta.dataProvider.LoginUserDataProvider;
import com.example.cursoseleniumjavaabstracta.pages.HomePage;
import com.example.cursoseleniumjavaabstracta.pages.LoginPage;
import com.example.cursoseleniumjavaabstracta.pages.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;


public class TestsFinalAbstracta {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private SignupPage signupPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);

    }

    @Test
    public void testLoginNegativoPasswordFinalSeleniumJava() throws Exception {
        homePage.openHomePage();
        homePage.clickLoginButton();
        loginPage.setUsername("Luca");
        loginPage.setPassword("12345678");
        loginPage.clickLoginModalButton();
        String alertText = loginPage.getAlertText();
        assertEquals(alertText, "Wrong password.");
        loginPage.acceptAlert();
    }

    @Test(dataProviderClass = LoginUserDataProvider.class, dataProvider = "loginUserData")
    public void testLoginFinalSeleniumJava(String username, String password) throws Exception {
        homePage.openHomePage();
        homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginModalButton();
        assertEquals(loginPage.getWelcomeMessage(), "Welcome " + username);
        loginPage.clickLogoutButton();

    }

    @Test
    public void testLoginNegativoUsernameFinalSeleniumJava() throws Exception {
        homePage.openHomePage();
        homePage.clickLoginButton();
        loginPage.setUsername("lllllllllll");
        loginPage.setPassword("12345678");
        loginPage.clickLoginModalButton();
        String alertText = loginPage.getAlertText();
        assertEquals(alertText, "User does not exist.");
        loginPage.acceptAlert();
    }

    @Test
    public void testLogoutFinalSeleniumJava() throws Exception {
        homePage.openHomePage();
        homePage.clickLoginButton();
        loginPage.setUsername("Luca17");
        loginPage.setPassword("12345678");
        loginPage.clickLoginModalButton();
        assertEquals(loginPage.getWelcomeMessage(), "Welcome Luca17");
        loginPage.clickLogoutButton();
        assertEquals(loginPage.getLoginButtonText(), "Log in");
    }

    @Test
    public void testSignupFinalSeleniumJava() throws Exception {
        homePage.openHomePage();
        homePage.clickSignupButton();
        signupPage.setUsername("Luca");
        signupPage.setPassword("12345678");
        signupPage.clickSignupModalButton();
        assertEquals(signupPage.getAlertText(), "Sign up successful.");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
