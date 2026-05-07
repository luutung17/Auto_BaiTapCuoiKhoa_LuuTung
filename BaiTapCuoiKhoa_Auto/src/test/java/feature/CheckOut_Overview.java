package feature;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ui.CheckOut_OverviewPageUI;
import untils.Hook_Inventory;

public class CheckOut_Overview extends Hook_Inventory {
    @Test
    public void testOverviewDisplayProduct() {

        System.out.println("--- Test sản phẩm hiển thị overview ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOut_OverviewPageUI.FIRST_NAME).sendKeys("Tung");
        driver.findElement(CheckOut_OverviewPageUI.LAST_NAME).sendKeys("Luu");
        driver.findElement(CheckOut_OverviewPageUI.POSTAL_CODE).sendKeys("100000");

        driver.findElement(CheckOut_OverviewPageUI.CONTINUE_BTN).click();

        WaitElement.Wait(driver, CheckOut_OverviewPageUI.OVERVIEW_PRODUCT_NAME);

        WebElement productName =
                driver.findElement(CheckOut_OverviewPageUI.OVERVIEW_PRODUCT_NAME);

        org.testng.Assert.assertEquals(productName.getText(), "Sauce Labs Backpack");
    }
    @Test
    public void testOverviewTotalPrice() {

        System.out.println("--- Test check giá + tổng tiền ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOut_OverviewPageUI.FIRST_NAME).sendKeys("Tung");
        driver.findElement(CheckOut_OverviewPageUI.LAST_NAME).sendKeys("Luu");
        driver.findElement(CheckOut_OverviewPageUI.POSTAL_CODE).sendKeys("100000");

        driver.findElement(CheckOut_OverviewPageUI.CONTINUE_BTN).click();

        WaitElement.Wait(driver, CheckOut_OverviewPageUI.TOTAL_PRICE);

        String itemTotal =
                driver.findElement(CheckOut_OverviewPageUI.ITEM_TOTAL).getText();

        String total =
                driver.findElement(CheckOut_OverviewPageUI.TOTAL_PRICE).getText();

        System.out.println(itemTotal);
        System.out.println(total);

        org.testng.Assert.assertTrue(total.contains("Total"));
    }
    @Test
    public void testFinishCheckout() {

        System.out.println("--- Test finish CheckOut ---");

        goToCheckOutPage.goToPage(driver);

        driver.findElement(CheckOut_OverviewPageUI.FIRST_NAME).sendKeys("Tung");
        driver.findElement(CheckOut_OverviewPageUI.LAST_NAME).sendKeys("Luu");
        driver.findElement(CheckOut_OverviewPageUI.POSTAL_CODE).sendKeys("100000");

        driver.findElement(CheckOut_OverviewPageUI.CONTINUE_BTN).click();

        driver.findElement(CheckOut_OverviewPageUI.FINISH_BTN).click();

        WaitElement.Wait(driver, CheckOut_OverviewPageUI.COMPLETE_MESSAGE);

        String message =
                driver.findElement(CheckOut_OverviewPageUI.COMPLETE_MESSAGE).getText();

        org.testng.Assert.assertEquals(message, "Thank you for your order!");
    }

}

