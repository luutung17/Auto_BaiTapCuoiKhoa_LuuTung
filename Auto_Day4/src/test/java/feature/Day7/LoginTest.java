package feature.Day7;

import action.LoginAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class LoginTestFullAnnotationsTest {
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
    }

    @Test
    public void testLoginValidUser() {
        System.out.println("--- @Test: Thực hiện test login với user hợp lệ ---");
        WebElement userInp = driver.findElement(By.id("user-name"));
        WebElement passInp = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userInp.sendKeys("standard_user");
        passInp.sendKeys("secret_sauce");
        loginBtn.click();
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login failed!");
    }

    @Test
    public void testLoginFailNotUser() {
        //Kiểm tra không có tên user

        System.out.println("--- @Test: Thực hiện test không có User ---");
        WebElement userInp = driver.findElement(By.id("user-name"));
        WebElement passInp = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userInp.sendKeys("");
        passInp.sendKeys("secret_sauce");
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username is required"));

    }

    @Test
    public void testLoginFailNotPassword() {
        //Kiểm tra không có mật kẩu
        System.out.println("--- @Test: Thực hiện test không có Password ---");
        WebElement userInp = driver.findElement(By.id("user-name"));
        WebElement passInp = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userInp.sendKeys("standard_user");
        passInp.sendKeys("");
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Password is required"));

    }

    @Test
    public void testLoginFailNotUserAndPassword() {
        LoginAction.performLogin(driver, "", "");
        //Kiểm tra để trống tên v̀ mật khẩu
        System.out.println("--- @Test: Thực hiện test không có User và Password---");
        WebElement userInp = driver.findElement(By.id("user-name"));
        WebElement passInp = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        userInp.sendKeys("");
        passInp.sendKeys("");
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username is required"));
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