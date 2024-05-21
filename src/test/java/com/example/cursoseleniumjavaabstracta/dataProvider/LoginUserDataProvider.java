package com.example.cursoseleniumjavaabstracta.dataProvider;

import org.testng.annotations.DataProvider;


public class LoginUserDataProvider {

    @DataProvider(name = "loginUserData")
    public static Object[][] loginUserData() {
        return new Object[][] {
                {"Luca17", "12345678"},
                {"Elena25", "abcdefg"}
        };
    }
}
