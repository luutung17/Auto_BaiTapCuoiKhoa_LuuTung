package feature;

import action.LoginAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ui.LoginPageUI;
import untils.Hook;


public class LoginTestFullAnnotationsTest extends Hook {

    @Test
    public void testLoginValidUser() {
        System.out.println("--- @Test: Thực hiện test login với user hợp lệ ---");
        LoginAction.performLogin(driver,"standard_user","secret_sauce");
        org.testng.Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login failed!");
    }

    @Test
    public void testLoginFailNotUser() {
        //Kiểm tra không có tên user
        System.out.println("--- @Test: Thực hiện test không có User ---");
        LoginAction.performLogin(driver, "", "secret_sauce");
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username is required"));

    }

    @Test
    public void testLoginFailNotPassword() {
        //Kiểm tra không có mật kẩu
        System.out.println("--- @Test: Thực hiện test không có Password ---");
        LoginAction.performLogin(driver, "standard_user", "");

        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Password is required"));

    }

    @Test
    public void testLoginFailNotUserAndPassword() {
        //Kiểm tra để trống tên v̀ mật khẩu
        System.out.println("--- @Test: Thực hiện test không có User ---");
        LoginAction.performLogin(driver, "", "");
        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username is required"));
    }

    @Test
    public void testLoginInvalidUser() {
        System.out.println("--- @Test: Thực hiện test login với user không hợp lệ ---");
        LoginAction.performLogin(driver, "locked_out_user1", "secret_sauce");
        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));

    }

    @Test
    public void testLoginInvalidPassword() {
        System.out.println("--- @Test: Thực hiện test login với password không hợp lệ ---");
        //Kiểm tra với sai mật khẩu
        LoginAction.performLogin(driver, "standard_user", "secret_sauce123");
        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginUsernameWithSpaces() {

        System.out.println("--- Test username có khoảng trắng ---");

        LoginAction.performLogin(driver, " standard_user ", "secret_sauce");
        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);
        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));

    }

    @Test
    public void testLoginPasswordWithSpaces() {
        System.out.println("--- Test password có khoảng trắng ---");

        LoginAction.performLogin(driver, "standard_user", " secret_sauce ");

        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);

        org.testng.Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        org.testng.Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));

    }

    @Test
    public void testLoginMultipleTimes() {
        System.out.println("--- Test login nhiều lần ---");

        LoginAction.performLogin(driver, "standard_user", "secret_sauce");

        driver.navigate().back();

        LoginAction.performLogin(driver, "standard_user", "secret_sauce");

        org.testng.Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
    }

}