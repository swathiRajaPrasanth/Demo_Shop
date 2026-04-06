package com.demoshop.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    
    public CartPage(WebDriver driver) {
        super(driver);
    }
    
    // You can add methods specific to the cart page here, like:
    public void verifyCartItems() {
        
        // Code to verify items in the cart
    }
    
}
