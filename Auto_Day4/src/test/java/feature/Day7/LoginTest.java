package feature.Day7;

import action.LoginAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ui.LoginPageUI;
import untils.Hook;


public class LoginTest extends Hook {

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
        WebElement errorMsg = driver.findElement(LoginPageUI.ERROR_FIELD);
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


}