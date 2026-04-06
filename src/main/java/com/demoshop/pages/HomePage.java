package com.demoshop.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(linkText = "Apparel & Shoes")
    private WebElement apparelCategoryLink;

    @FindBy(linkText = "Shopping cart")
    private WebElement shoppingCartLink;

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickApparelCategory() {
        apparelCategoryLink.click();
    }

    public void clickShoppingCart() {
        shoppingCartLink.click();
    }

    public void clickLogout() {
        logoutLink.click();
    }


    
}
