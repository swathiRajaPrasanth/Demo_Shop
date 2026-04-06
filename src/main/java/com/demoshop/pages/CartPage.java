package com.demoshop.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(className = "cart-item-row")
    private List<WebElement> cartItems;
    
    public CartPage(WebDriver driver) {
        super(driver);
    }
    
    // You can add methods specific to the cart page here, like:
    public void verifyCartItems(List<String> expectedProducts) {
        System.out.println("Verifying cart items...");
        System.out.println("Number of cart items found: " + cartItems.size());
        
        for (WebElement item : cartItems) {
            String itemText = item.getText();
            System.out.println("Cart Item: " + itemText);
            boolean found = false;
            for (String expectedProduct : expectedProducts) {
                if (itemText.contains(expectedProduct)) {
                    System.out.println("Product '" + expectedProduct + "' is in the cart.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Unexpected product in cart: " + itemText);
            }
        }
        
        // Check if all expected products are in the cart
        for (String expectedProduct : expectedProducts) {
            boolean inCart = false;
            for (WebElement item : cartItems) {
                if (item.getText().contains(expectedProduct)) {
                    inCart = true;
                    break;
                }
            }
            if (!inCart) {
                System.out.println("Expected product '" + expectedProduct + "' is NOT in the cart.");
            }
        }
    }
    
}
