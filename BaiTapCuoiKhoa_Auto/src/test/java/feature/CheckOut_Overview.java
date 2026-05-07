package feature;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckOut_YourInformation {
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
    public void testCheckoutInfo_ValidData() {

        System.out.println("--- Test Checkout với dữ liệu hợp lệ ---");

        goToCheckOutPage.goToPage(driver);

        // nhập data
        driver.findElement(By.id("first-name")).sendKeys("Tung");
        driver.findElement(By.id("last-name")).sendKeys("Luu");
        driver.findElement(By.id("postal-code")).sendKeys("100000");

        driver.findElement(By.id("continue")).click();

        // verify sang step 2
        WaitElement.Wait(driver,"[class=\"btn btn_action btn_medium cart_button\"]");

        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),
                "Did not go to step 2!");
    }

    @Test
    public void testCheckout_MissingFirstName() {

        System.out.println("--- Test thiếu First Name ---");
        goToCheckOutPage.goToPage(driver);

        driver.findElement(By.id("last-name")).sendKeys("Luu");
        driver.findElement(By.id("postal-code")).sendKeys("100000");
        driver.findElement(By.id("continue")).click();

        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));

        org.testng.Assert.assertTrue(error.getText().contains("First Name is required"));
    }
    @Test
    public void testCheckout_MissingLastName() {

        System.out.println("--- Test thiếu Last Name ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(By.id("first-name")).sendKeys("Tung");
        driver.findElement(By.id("postal-code")).sendKeys("100000");
        driver.findElement(By.id("continue")).click();

        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));

        org.testng.Assert.assertTrue(error.getText().contains("Last Name is required"));
    }
    @Test
    public void testCheckout_MissingPostalCode() {

        System.out.println("--- Test thiếu Postal Code ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(By.id("first-name")).sendKeys("Tung");
        driver.findElement(By.id("last-name")).sendKeys("Luu");
        driver.findElement(By.id("continue")).click();

        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));

        org.testng.Assert.assertTrue(error.getText().contains("Postal Code is required"));
    }
    @Test
    public void testCheckout_AllFieldsEmpty() {

        System.out.println("--- Test bỏ trống tất cả ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(By.id("continue")).click();

        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));

        org.testng.Assert.assertTrue(error.getText().contains("First Name is required"));
    }
    @Test
    public void testCheckout_CancelButton() {

        System.out.println("--- Test nút Cancel ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(By.id("cancel")).click();

        WaitElement.Wait(driver,".cart_list");

        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "Cancel không quay về cart!");
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

