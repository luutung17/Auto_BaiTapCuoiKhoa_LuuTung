package feature;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import ui.CheckoutPageUI;
import ui.InventoryPageUI;
import untils.Hook_Inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckOut extends Hook_Inventory {



    @Test
    public void testCheckOut_TestProduct() {
        System.out.println("--- @Test: Thực hiện test Chức năng kiểm tra sản phẩm sau khi cho vào giỏ hàng ---");
        AddToCart.Click(driver, InventoryPageUI.ADDTOCART_BACKPACK);
        WebElement product1 = driver.findElement(InventoryPageUI.PRODUCT_1); // Backpack
        String name1 = product1.getText();
        String desc1 = driver.findElement(InventoryPageUI.PRODUCT_1)
                .findElement(InventoryPageUI.PRODUCT_DESC)
                .getText();
        String price1 = driver.findElement(InventoryPageUI.PRODUCT_1)
                .findElement(InventoryPageUI.PRODUCT_PRICE)
                .getText();
        AddToCart.Click(driver, InventoryPageUI.ADDTOCART_TSHIRT);
        WebElement product2 = driver.findElement(InventoryPageUI.PRODUCT_2); // T-shirt

        String name2 = product2.getText();
        String desc2 = driver.findElement(InventoryPageUI.PRODUCT_2)
                .findElement(InventoryPageUI.PRODUCT_DESC)
                .getText();
        String price2 = driver.findElement(InventoryPageUI.PRODUCT_2)
                .findElement(InventoryPageUI.PRODUCT_PRICE)
                .getText();

        // WAIT
        WaitElement.Wait(driver, CheckoutPageUI.CART_BADGE);

        CheckOut_TestProduct.Click(driver);
        WaitElement.Wait(driver, CheckoutPageUI.CART_ITEM);
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
        boolean foundProduct1 = false;
        boolean foundProduct2 = false;

        for (WebElement item : cartItems) {

            String name = item.findElement(CheckoutPageUI.CART_ITEM_NAME).getText();
            String desc = item.findElement(CheckoutPageUI.CART_ITEM_DESC).getText();
            String price = item.findElement(CheckoutPageUI.CART_ITEM_PRICE).getText();

            if (name.equals(name1)) {
                org.testng.Assert.assertEquals(desc, desc1);
                org.testng.Assert.assertEquals(price, price1);
                foundProduct1 = true;
            }

            if (name.equals(name2)) {
                org.testng.Assert.assertEquals(desc, desc2);
                org.testng.Assert.assertEquals(price, price2);
                foundProduct2 = true;
            }
        }


        org.testng.Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Failed URL Check Out!");
        org.testng.Assert.assertTrue(foundProduct1, "Product 1 not found in cart!");
        org.testng.Assert.assertTrue(foundProduct2, "Product 2 not found in cart!");
    }

    @Test
    public void testRemoveProductInCart() {

        System.out.println("--- Test Remove product trong cart ---");

        AddToCart.Click(driver,
                InventoryPageUI.ADDTOCART_BACKPACK);

        CheckOut_TestProduct.Click(driver);

        WaitElement.Wait(driver, CheckoutPageUI.CART_ITEM);

        driver.findElement(
                CheckoutPageUI.REMOVE_BUTTON).click();

        List<WebElement> items =
                driver.findElements(CheckoutPageUI.CART_ITEM);

        org.testng.Assert.assertEquals(items.size(), 0);
    }

    @Test
    public void testContinueShopping() {

        System.out.println("--- Test Continue Shopping ---");

        AddToCart.Click(driver,
                InventoryPageUI.ADDTOCART_BACKPACK);

        CheckOut_TestProduct.Click(driver);

        WaitElement.Wait(driver, CheckoutPageUI.CONTINUE_SHOPPING_BTN);

        driver.findElement(CheckoutPageUI.CONTINUE_SHOPPING_BTN).click();

        WaitElement.Wait(driver, CheckoutPageUI.INVENTORY_LIST);

        org.testng.Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void testCheckoutButton() {

        System.out.println("--- Test Checkout button ---");

        AddToCart.Click(driver,
                InventoryPageUI.ADDTOCART_BACKPACK);

        CheckOut_TestProduct.Click(driver);

        WaitElement.Wait(driver, CheckoutPageUI.CHECKOUT_BTN);

        driver.findElement(CheckoutPageUI.CHECKOUT_BTN).click();

        WaitElement.Wait(driver, CheckoutPageUI.FIRST_NAME);

        org.testng.Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-one"));
    }


}
