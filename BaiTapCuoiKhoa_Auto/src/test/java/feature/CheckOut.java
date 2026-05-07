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

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventoryManagementFullAnnotationsTest {
    WebDriver driver;

    @BeforeClass //mtw1 lần
    public void beforeClass() {
        System.out.println("=== @BeforeClass: Khởi tạo Driver - Chạy trước các method trong class này ===");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("=== @BeforeMethod: Mở trang web - Chạy trước mỗi test case (@Test) ===");
        driver.get("https://www.saucedemo.com/");
        LoginAction.performLogin(driver, "standard_user", "secret_sauce");
    }

    @Test
    public void testInterFaceWithHeaderLable() {
        System.out.println("--- @Test: Thực hiện test với giao diện có headerLable ---");
        WebElement elementHeaderLable = driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/following-sibling::div[@class=\"header_label\"]/div[@class=\"app_logo\"]"));
        org.testng.Assert.assertEquals(elementHeaderLable.getText(), "Swag Labs", "Header Lable don't have");
    }

    @Test
    public void testClickOpenMenu() {
        System.out.println("--- @Test: Thực hiện test click vào Open Menu ---");
        OpenMenu.Click(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement elementMenu = driver.findElement(By.cssSelector("[class=\"bm-menu-wrap\"][aria-hidden=\"false\"]"));
        org.testng.Assert.assertTrue(elementMenu.isDisplayed(), "Menu don't display!");
    }

    @Test
    public void testOpenMenuDisplayItems() {

        System.out.println("--- Test Open Menu hiển thị các menu ---");

        OpenMenu.Click(driver);
        WaitElement.Wait(driver,"[data-test='inventory-sidebar-link']");

        WebElement allItems=driver.findElement(By.cssSelector("[data-test='inventory-sidebar-link']"));
        WebElement about = driver.findElement(By.cssSelector("[data-test='about-sidebar-link']"));
        WebElement logout = driver.findElement(By.cssSelector("[data-test='logout-sidebar-link']"));
        WebElement reset = driver.findElement(By.cssSelector("[data-test='reset-sidebar-link']"));

        org.testng.Assert.assertEquals(allItems.getText(), "All Items");
        org.testng.Assert.assertEquals(about.getText(), "About");
        org.testng.Assert.assertEquals(logout.getText(), "Logout");
        org.testng.Assert.assertEquals(reset.getText(), "Reset App State");
    }
    @Test
    public void testClickAbout() {
        System.out.println("--- Test Click About trong Menu ---");
        OpenMenu.Click(driver);
        WaitElement.Wait(driver,"[data-test=\"about-sidebar-link\"]");
        About.Click(driver);
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Failed with About!");
    }
    @Test
    public void testClickLogOut() {
        System.out.println("--- Test Click About trong Menu ---");
        OpenMenu.Click(driver);
        WaitElement.Wait(driver,"[data-test=\"about-sidebar-link\"]");
        LogOut.Click(driver);
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "Failed with Log Out!");
    }

    @Test
    public void testSortProduct() {
        System.out.println("--- @Test: Thực hiện test Sắp xếp Product ---");
        SortProduct.Click(driver);
        WaitElement.Wait(driver,"[value='az']");
        WebElement az= driver.findElement(By.cssSelector("[value='az']"));
        WebElement za= driver.findElement(By.cssSelector("[value='za']"));
        WebElement lohi= driver.findElement(By.cssSelector("[value='lohi']"));
        WebElement hilo= driver.findElement(By.cssSelector("[value='hilo']"));

        org.testng.Assert.assertEquals(az.getText(), "Name (A to Z)");
        org.testng.Assert.assertEquals(za.getText(), "Name (Z to A)");
        org.testng.Assert.assertEquals(lohi.getText(), "Price (low to high)");
        org.testng.Assert.assertEquals(hilo.getText(), "Price (high to low)");
    }
    @Test
    public void testProductInterface() {
        System.out.println("--- Test giao diện sản phẩm ---");

        WaitElement.Wait(driver,".inventory_item");

        java.util.List<WebElement> products =
                driver.findElements(By.cssSelector(".inventory_item"));

        for(WebElement product : products){

            WebElement img = product.findElement(By.cssSelector(".inventory_item_img"));
            WebElement name = product.findElement(By.cssSelector(".inventory_item_name"));
            WebElement desc = product.findElement(By.cssSelector(".inventory_item_desc"));
            WebElement price = product.findElement(By.cssSelector(".inventory_item_price"));
            WebElement button = product.findElement(By.cssSelector("button"));

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
                driver.findElement(By.cssSelector(".inventory_item_name"));

        productName.click();

        WaitElement.Wait(driver,".inventory_details_name");

        WebElement detailName =
                driver.findElement(By.cssSelector(".inventory_details_name"));

        org.testng.Assert.assertTrue(detailName.isDisplayed(),
                "Product detail page not open!");
    }
    @Test
    public void testClickProductImage() {

        System.out.println("--- Test click image product ---");

        WebElement productImage =
                driver.findElement(By.cssSelector(".inventory_item_img"));

        productImage.click();

        WaitElement.Wait(driver,".inventory_details_container");

        WebElement detailPage =
                driver.findElement(By.cssSelector(".inventory_details_container"));

        org.testng.Assert.assertTrue(detailPage.isDisplayed(),
                "Product detail page not display!");
    }
    @Test
    public void testAddToCart() {
        System.out.println("--- @Test: Thực hiện test Chức năng Add to cart ---");
        AddToCart.Click(driver,"[name='add-to-cart-sauce-labs-backpack']");
        AddToCart.Click(driver,"[name='add-to-cart-sauce-labs-bolt-t-shirt']");
        WaitElement.Wait(driver,"[class='shopping_cart_badge'][data-test='shopping-cart-badge']");
        WaitElement.Wait(driver,"[id='remove-sauce-labs-backpack']");
        WaitElement.Wait(driver,"[id='remove-sauce-labs-bolt-t-shirt']");

        WebElement removeProduct1= driver.findElement(By.cssSelector("[id='remove-sauce-labs-backpack']"));
        WebElement removeProduct2= driver.findElement(By.cssSelector("[id='remove-sauce-labs-bolt-t-shirt']"));
        WebElement numberProduct = driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
        org.testng.Assert.assertEquals(removeProduct1.getText(), "Remove", "Button 1 does not say Remove!");
        org.testng.Assert.assertEquals(removeProduct2.getText(), "Remove", "Button 2 does not say Remove!");
        org.testng.Assert.assertEquals(numberProduct.getText(),"2","Number Product don't true!");
    }
    @Test
    public void testRemoveProduct() {

        System.out.println("--- Test remove product ---");

        AddToCart.Click(driver,"[name='add-to-cart-sauce-labs-backpack']");

        WaitElement.Wait(driver,"[name='remove-sauce-labs-backpack']");

        AddToCart.Click(driver,"[name='remove-sauce-labs-backpack']");

        WebElement addButton =
                driver.findElement(By.cssSelector("[name='add-to-cart-sauce-labs-backpack']"));

        org.testng.Assert.assertEquals(addButton.getText(),
                "Add to cart","Remove not working!");
    }
    @Test
    public void testShoppingCartIcon() {

        System.out.println("--- Test click cart icon ---");

        WebElement cart =
                driver.findElement(By.cssSelector(".shopping_cart_link"));

        cart.click();

        WaitElement.Wait(driver,".cart_list");

        WebElement cartPage =
                driver.findElement(By.cssSelector(".cart_list"));

        org.testng.Assert.assertTrue(cartPage.isDisplayed(),
                "Cart page not open!");
    }
    @Test
    public void testSortZToAProduct() {

        System.out.println("--- Test sắp xếp sản phẩm theo Z to A ---");
        WebElement sortDropdown = driver.findElement(By.cssSelector("[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);
        select.selectByValue("za");
        WaitElement.Wait(driver,".inventory_item_name");
        List<WebElement> productsName=driver.findElements(By.cssSelector(".inventory_item_name"));
        List<String> actualProducts= new ArrayList<>();
        for (WebElement productName:productsName){
            actualProducts.add(productName.getText());
        }
        List<String> expectedProducts = new ArrayList<>(actualProducts);
        Collections.sort(expectedProducts, Collections.reverseOrder()); // Sorts alphabetically
        org.testng.Assert.assertEquals(actualProducts,expectedProducts,"List products not true!");
    }
    @Test
    public void testSortPriceLowToHigh() {

        System.out.println("--- Test sắp xếp sản phẩm theo giá từ thấp đến cao ---");

        WebElement sortDropdown = driver.findElement(By.cssSelector("[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);

        select.selectByValue("lohi");

        WaitElement.Wait(driver,".inventory_item_price");

        List<WebElement> productsPrice = driver.findElements(By.cssSelector(".inventory_item_price"));

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement price : productsPrice){
            String priceText = price.getText().replace("$","");
            actualPrices.add(Double.parseDouble(priceText));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices); // Low → High

        org.testng.Assert.assertEquals(actualPrices, expectedPrices,
                "Prices are not sorted from low to high!");
    }
    @Test
    public void testSortPriceHighToLow() {

        System.out.println("--- Test sắp xếp sản phẩm theo giá từ cao đến thấp ---");

        WebElement sortDropdown = driver.findElement(By.cssSelector("[data-test='product-sort-container']"));
        Select select = new Select(sortDropdown);

        select.selectByValue("hilo");

        WaitElement.Wait(driver,".inventory_item_price");

        List<WebElement> productsPrice = driver.findElements(By.cssSelector(".inventory_item_price"));

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement price : productsPrice){
            String priceText = price.getText().replace("$","");
            actualPrices.add(Double.parseDouble(priceText));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices,Collections.reverseOrder()); // Low → High

        org.testng.Assert.assertEquals(actualPrices, expectedPrices,
                "Prices are not sorted from low to high!");
    }


    @AfterClass
    public void afterClass() {
        System.out.println("=== @AfterClass: Đóng Driver - Chạy sau tất cả các method trong class này ===");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("=== @AfterSuite: Chạy cuối cùng, sau tất cả các test trong suite ===");
    }
}
