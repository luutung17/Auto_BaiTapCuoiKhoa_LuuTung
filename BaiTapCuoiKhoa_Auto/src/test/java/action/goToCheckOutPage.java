package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.InventoryPageUI;

public class goToCheckOutPage {
    public static void goToPage(WebDriver driver) {
        AddToCart.Click(driver, InventoryPageUI.ADDTOCART_BACKPACK);
        CheckOut_TestProduct.Click(driver);
        driver.findElement(By.id("checkout")).click();
        WaitElement.Wait(driver,InventoryPageUI.FIRST_NAME);
    }
}
