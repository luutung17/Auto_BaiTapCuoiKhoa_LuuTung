package feature;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ui.CheckOutPage_YourInforMationUI;
import untils.Hook_Inventory;

public class CheckOut_YourInformation extends Hook_Inventory {

    @Test
    public void testCheckoutInfo_ValidData() {

        System.out.println("--- Test Checkout với dữ liệu hợp lệ ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOutPage_YourInforMationUI.FIRST_NAME).sendKeys("Tung");
        driver.findElement(CheckOutPage_YourInforMationUI.LAST_NAME).sendKeys("Luu");
        driver.findElement(CheckOutPage_YourInforMationUI.POSTAL_CODE).sendKeys("100000");

        driver.findElement(CheckOutPage_YourInforMationUI.CONTINUE_BTN).click();

        WaitElement.Wait(driver, CheckOutPage_YourInforMationUI.CHECKOUT_STEP_TWO);

        org.testng.Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two"),
                "Did not go to step 2!"
        );
    }

    @Test
    public void testCheckout_MissingFirstName() {

        System.out.println("--- Test thiếu First Name ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOutPage_YourInforMationUI.LAST_NAME).sendKeys("Luu");
        driver.findElement(CheckOutPage_YourInforMationUI.POSTAL_CODE).sendKeys("100000");

        driver.findElement(CheckOutPage_YourInforMationUI.CONTINUE_BTN).click();
        WebElement error = driver.findElement(CheckOutPage_YourInforMationUI.ERROR_MESSAGE);

        org.testng.Assert.assertTrue(
                error.getText().contains("First Name is required")
        );
    }
    @Test
    public void testCheckout_MissingLastName() {

        System.out.println("--- Test thiếu Last Name ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOutPage_YourInforMationUI.FIRST_NAME).sendKeys("Tung");
        driver.findElement(CheckOutPage_YourInforMationUI.POSTAL_CODE).sendKeys("100000");

        driver.findElement(CheckOutPage_YourInforMationUI.CONTINUE_BTN).click();

        WebElement error = driver.findElement(CheckOutPage_YourInforMationUI.ERROR_MESSAGE);

        org.testng.Assert.assertTrue(
                error.getText().contains("Last Name is required")
        );
    }
    @Test
    public void testCheckout_MissingPostalCode() {

        System.out.println("--- Test thiếu Postal Code ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOutPage_YourInforMationUI.FIRST_NAME).sendKeys("Tung");
        driver.findElement(CheckOutPage_YourInforMationUI.LAST_NAME).sendKeys("Luu");

        driver.findElement(CheckOutPage_YourInforMationUI.CONTINUE_BTN).click();

        WebElement error = driver.findElement(CheckOutPage_YourInforMationUI.ERROR_MESSAGE);

        org.testng.Assert.assertTrue(
                error.getText().contains("Postal Code is required")
        );
    }
    @Test
    public void testCheckout_AllFieldsEmpty() {

        System.out.println("--- Test bỏ trống tất cả ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOutPage_YourInforMationUI.CONTINUE_BTN).click();

        WebElement error = driver.findElement(CheckOutPage_YourInforMationUI.ERROR_MESSAGE);

        org.testng.Assert.assertTrue(
                error.getText().contains("First Name is required")
        );
    }
    @Test
    public void testCheckout_CancelButton() {

        System.out.println("--- Test nút Cancel ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOutPage_YourInforMationUI.CANCEL_BTN).click();

        WaitElement.Wait(driver, CheckOutPage_YourInforMationUI.CART_PAGE);

        org.testng.Assert.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "Cancel không quay về cart!"
        );
    }

}

