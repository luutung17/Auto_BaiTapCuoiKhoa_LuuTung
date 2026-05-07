package feature;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ui.InventoryPageUI;
import untils.Hook_Inventory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventoryManagementFullAnnotationsTest extends Hook_Inventory {

    @Test
    public void testInterFaceWithHeaderLable() {
        System.out.println("--- @Test: Thực hiện test với giao diện có headerLable ---");
        WebElement elementHeaderLable = driver.findElement(InventoryPageUI.HEADERLABLE_FIELD);
        org.testng.Assert.assertEquals(elementHeaderLable.getText(), "Swag Labs", "Header Lable don't have");
    }

    @Test
    public void testClickOpenMenu() {
        System.out.println("--- @Test: Thực hiện test click vào Open Menu ---");
        OpenMenu.Click(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement elementMenu = driver.findElement(InventoryPageUI.MENU_FIELD);
        org.testng.Assert.assertTrue(elementMenu.isDisplayed(), "Menu don't display!");
    }

    @Test
    public void testOpenMenuDisplayItems() {

        System.out.println("--- Test Open Menu hiển thị các menu ---");

        OpenMenu.Click(driver);
        WaitElement.Wait(driver,InventoryPageUI.ALL_ITEMS);

        WebElement allItems=driver.findElement(InventoryPageUI.ALL_ITEMS);
        WebElement about = driver.findElement(InventoryPageUI.ABOUT);
        WebElement logout = driver.findElement(InventoryPageUI.LOGOUT);
        WebElement reset = driver.findElement(InventoryPageUI.RESET);

        org.testng.Assert.assertEquals(allItems.getText(), "All Items");
        org.testng.Assert.assertEquals(about.getText(), "About");
        org.testng.Assert.assertEquals(logout.getText(), "Logout");
        org.testng.Assert.assertEquals(reset.getText(), "Reset App State");
    }
    @Test
    public void testClickAbout() {
        System.out.println("--- Test Click About ---");

        OpenMenu.Click(driver);

        WaitElement.Wait(driver, InventoryPageUI.ABOUT);

        driver.findElement(InventoryPageUI.ABOUT).click();

        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }
    @Test
    public void testClickLogOut() {
        System.out.println("--- Test Logout ---");

        OpenMenu.Click(driver);

        WaitElement.Wait(driver, InventoryPageUI.LOGOUT);

        driver.findElement(InventoryPageUI.LOGOUT).click();

        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }

    @Test
    public void testSortProduct() {
        System.out.println("--- @Test: Thực hiện test Sắp xếp Product ---");
        SortProduct.Click(driver);
        WaitElement.Wait(driver,InventoryPageUI.AZ);
        WebElement az= driver.findElement(InventoryPageUI.AZ);
        WebElement za= driver.findElement(InventoryPageUI.ZA);
        WebElement lohi= driver.findElement(InventoryPageUI.LOHI);
        WebElement hilo= driver.findElement(InventoryPageUI.HILO);

        org.testng.Assert.assertEquals(az.getText(), "Name (A to Z)");
        org.testng.Assert.assertEquals(za.getText(), "Name (Z to A)");
        org.testng.Assert.assertEquals(lohi.getText(), "Price (low to high)");
        org.testng.Assert.assertEquals(hilo.getText(), "Price (high to low)");
    }
    @Test
    public void testProductInterface() {
        System.out.println("--- Test giao diện sản phẩm ---");

        WaitElement.Wait(driver,InventoryPageUI.PRODUCTS);

        java.util.List<WebElement> products =
                driver.findElements(InventoryPageUI.PRODUCTS);

        for(WebElement product : products){

            WebElement img = product.findElement(InventoryPageUI.IMG);
            WebElement name = product.findElement(InventoryPageUI.NAME);
            WebElement desc = product.findElement(InventoryPageUI.DESC);
            WebElement price = product.findElement(InventoryPageUI.PRICE);
            WebElement button = product.findElement(InventoryPageUI.BUTTON);

            org.testng.Assert.assertTrue(img.isDisplayed(),"Image not display");
            org.testng.Assert.assertTrue(name.isDisplayed(),"Name not display");
            org.testng.Assert.assertTrue(desc.isDisplayed(),"Description not display");
            org.testng.Assert.assertTrue(price.isDisplayed(),"Price not display");
            org.testng.Assert.assertEquals(button.getText(),"Add to cart","Button wrong text");
        }
    }
    @Test
    public void testClickProductName() {

        System.out.println("--- Test click vào product name ---");

        WebElement productName =
                driver.findElement(InventoryPageUI.NAME);

        productName.click();

        WaitElement.Wait(driver,InventoryPageUI.DETAILS_NAME);

        WebElement detailName =
                driver.findElement(InventoryPageUI.DETAILS_NAME);

        org.testng.Assert.assertTrue(detailName.isDisplayed(),
                "Product detail page not open!");
    }
    @Test
    public void testClickProductImage() {

        System.out.println("--- Test click image product ---");

        WebElement productImage =
                driver.findElement(InventoryPageUI.IMG);

        productImage.click();

        WaitElement.Wait(driver,InventoryPageUI.DETAILS_CONTAINER);

        WebElement detailPage =
                driver.findElement(InventoryPageUI.DETAILS_CONTAINER);

        org.testng.Assert.assertTrue(detailPage.isDisplayed(),
                "Product detail page not display!");
    }
    @Test
    public void testAddToCart() {
        System.out.println("--- @Test: Thực hiện test Chức năng Add to cart ---");
        AddToCart.Click(driver,InventoryPageUI.ADDTOCART_BACKPACK);
        AddToCart.Click(driver,InventoryPageUI.ADDTOCART_TSHIRT);
        WaitElement.Wait(driver,InventoryPageUI.CART_BADGE);
        WaitElement.Wait(driver,InventoryPageUI.REMOVE_BACKPACK);
        WaitElement.Wait(driver,InventoryPageUI.REMOVE_TSHIRT);

        WebElement removeProduct1= driver.findElement(InventoryPageUI.REMOVE_BACKPACK);
        WebElement removeProduct2= driver.findElement(InventoryPageUI.REMOVE_TSHIRT);
        WebElement numberProduct = driver.findElement(InventoryPageUI.CART_BADGE);
        org.testng.Assert.assertEquals(removeProduct1.getText(), "Remove", "Button 1 does not say Remove!");
        org.testng.Assert.assertEquals(removeProduct2.getText(), "Remove", "Button 2 does not say Remove!");
        org.testng.Assert.assertEquals(numberProduct.getText(),"2","Number Product don't true!");
    }
    @Test
    public void testRemoveProduct() {

        System.out.println("--- Test remove product ---");

        AddToCart.Click(driver,InventoryPageUI.ADDTOCART_BACKPACK);

        WaitElement.Wait(driver,InventoryPageUI.REMOVE_BACKPACK);

        AddToCart.Click(driver,InventoryPageUI.REMOVE_BACKPACK);

        WebElement addButton =
                driver.findElement(InventoryPageUI.ADDTOCART_BACKPACK);

        org.testng.Assert.assertEquals(addButton.getText(),
                "Add to cart","Remove not working!");
    }
    @Test
    public void testShoppingCartIcon() {

        System.out.println("--- Test Cart Icon ---");

        driver.findElement(InventoryPageUI.CART_ICON).click();

        WaitElement.Wait(driver, InventoryPageUI.CART_PAGE);

        org.testng.Assert.assertTrue(
                driver.findElement(InventoryPageUI.CART_PAGE).isDisplayed()
        );
    }
    @Test
    public void testSortZToAProduct() {

        System.out.println("--- Test Sort Z-A ---");

        Select select = new Select(
                driver.findElement(InventoryPageUI.SORT_DROPDOWN)
        );

        select.selectByValue("za");

        WaitElement.Wait(driver, InventoryPageUI.NAME);

        List<WebElement> elements =
                driver.findElements(InventoryPageUI.NAME);

        List<String> actual = new ArrayList<>();

        for (WebElement e : elements) {
            actual.add(e.getText());
        }

        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected, Collections.reverseOrder());

        org.testng.Assert.assertEquals(actual, expected);
    }
    @Test
    public void testSortPriceLowToHigh() {

        System.out.println("--- Test Sort Price Low → High ---");

        Select select = new Select(
                driver.findElement(InventoryPageUI.SORT_DROPDOWN)
        );

        select.selectByValue("lohi");

        WaitElement.Wait(driver, InventoryPageUI.PRICE);

        List<WebElement> elements =
                driver.findElements(InventoryPageUI.PRICE);

        List<Double> actual = new ArrayList<>();

        for (WebElement e : elements) {
            actual.add(Double.parseDouble(e.getText().replace("$", "")));
        }

        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);

        org.testng.Assert.assertEquals(actual, expected);
    }
    @Test
    public void testSortPriceHighToLow() {

        System.out.println("--- Test Sort Price High → Low ---");

        Select select = new Select(
                driver.findElement(InventoryPageUI.SORT_DROPDOWN)
        );

        select.selectByValue("hilo");

        WaitElement.Wait(driver, InventoryPageUI.PRICE);

        List<WebElement> elements =
                driver.findElements(InventoryPageUI.PRICE);

        List<Double> actual = new ArrayList<>();

        for (WebElement e : elements) {
            actual.add(Double.parseDouble(e.getText().replace("$", "")));
        }

        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected, Collections.reverseOrder());

        org.testng.Assert.assertEquals(actual, expected);
    }


}
