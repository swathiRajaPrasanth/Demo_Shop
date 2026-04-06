package com.demoshop.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparelPage extends BasePage {
    @FindBy(xpath = "//*[@class='product-title']/a")
    private List<WebElement> productLink;

    public ApparelPage(WebDriver driver) {
        super(driver);
    }
    
    // You can add methods specific to the apparel page here, like:
    public List<String> selectProducts(int index) {
        int productCount = productLink.size();
        List<String> addedProducts = new ArrayList<>();

        for (int i = 0; i < index && i < productCount; i++) {
            String productName = productLink.get(i).getText();
            System.out.println("Product name: " + productName);
            productLink.get(i).click();
            System.out.println("Page title after navigating to product details is: " + driver.getTitle());
            try {
                // Find the add to cart button on the product details page
                WebElement addToCartButton = driver.findElement(By.xpath("//input[@value='Add to cart']"));
                addToCartButton.click();
                addedProducts.add(productName);
                System.out.println("Added to cart: " + productName);
            } catch (Exception e) {
                System.out.println("Add to cart button not found for product: " + productName);
                continue;
            }

            driver.navigate().back();
        }
        return addedProducts;
    }
    
}
