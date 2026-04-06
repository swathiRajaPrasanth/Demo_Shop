package com.demoshop.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparelPage extends BasePage {
    @FindBy(xpath = "//*[@class='product-title']/a")
    private List<WebElement> productLink;
    @FindBy (xpath = "(//input[@value='Add to cart'])[1]")
    private WebElement addToCartButton;

    public ApparelPage(WebDriver driver) {
        super(driver);
    }
    
    // You can add methods specific to the apparel page here, like:
    public void selectProducts(int index)
 {
            int productCount = productLink.size();

            for (int i = 0; i < productCount; i++) {
            System.out.println("Number of products found: " + productCount);
           // +1 to make it 1-based index
               if (productCount >3) {
                     break;
               }
                System.out.println("Product name: " + productLink.get(i).getText());
                productLink.get(i).click();
                System.out.println("Page title after navigating to product details is: " + driver.getTitle());
                try
                {
                addToCartButton.click();
                }
                catch(Exception e)
                {
                    System.out.println("Add to cart button not found for product: " + productLink.get(i).getText());
                    continue;
                }

                driver.navigate().back();
            }
   
    }
    
}
