package com.demoshop.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

import com.demoshop.pages.HomePage;
import com.demoshop.pages.LoginPage;
import com.demoshop.pages.ApparelPage;
import com.demoshop.utils.DecodeUtils;
import com.demoshop.pages.CartPage;

public class DemoShopTest extends BaseTest {

           
             
    @Test(priority = 1)
    public void testDemoShop() {
        try {

              HomePage home = new HomePage(driver);
              LoginPage login = new LoginPage(driver);
             ApparelPage apparel = new ApparelPage(driver);
             CartPage cart = new CartPage(driver);
            // 2. Navigate to a URL
            
            String homeTitle = home.getPageTitle();
            Assert.assertEquals(homeTitle, "Demo Web Shop");
            home.clickLogin();
            String loginTitle = login.getPageTitle();
            Assert.assertEquals(loginTitle, "Demo Web Shop. Login");
            login.login("swati8959@gmail.com", DecodeUtils.getDecodedPassword("VGVzdEAxMjM="));
            String loggedinHomeTitle = home.getPageTitle();
            Assert.assertEquals(loggedinHomeTitle, "Demo Web Shop");
            home.clickApparelCategory();
            String apparelTitle = apparel.getPageTitle();
            Assert.assertEquals(apparelTitle, "Demo Web Shop. Apparel & Shoes");
            List<String> addedProducts = apparel.selectProducts(3);

            home.clickShoppingCart();
            String cartTitle = home.getPageTitle();
            Assert.assertEquals(cartTitle, "Demo Web Shop. Shopping Cart");
            cart.verifyCartItems(addedProducts);
            home.clickLogout();
            String logoutTitle = home.getPageTitle();
            Assert.assertEquals(logoutTitle, "Demo Web Shop");

            

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void testInvalidLogin() {
        try {
            HomePage home = new HomePage(driver);
            LoginPage login = new LoginPage(driver);
            home.clickLogin();
            login.login("invalid@example.com", "invalidpassword");
            Assert.assertTrue(login.isErrorMessageDisplayed(), "Expected error message not displayed");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void addToCartWithoutLogin() {
        try {
            HomePage home = new HomePage(driver);
            ApparelPage apparel = new ApparelPage(driver);
            home.clickApparelCategory();
            apparel.selectProducts(3); // Attempt to add the first product to the cart without logging in
            home.clickShoppingCart();
            String cartTitle = home.getPageTitle();
            Assert.assertEquals(cartTitle, "Demo Web Shop. Shopping Cart");
            
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }
}
