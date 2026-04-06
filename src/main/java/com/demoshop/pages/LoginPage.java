package com.demoshop.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(), 'Login was unsuccessful')]")
    private WebElement errorMessage;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    // You can add methods specific to the login page here, like:
    public void login(String email, String password) {
        emailField.sendKeys(email); 
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    } catch (Exception e) {
        return false;
    }
    }
    }
    

