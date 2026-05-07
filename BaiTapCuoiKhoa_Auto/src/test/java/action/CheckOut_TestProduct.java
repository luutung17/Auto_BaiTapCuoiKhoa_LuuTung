package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.InventoryPageUI;

public class CheckOut_TestProduct {
    public static void Click(WebDriver driver) {
        WebElement elementTestProduct= driver.findElement(InventoryPageUI.CART_ICON);
        elementTestProduct.click();
    }
}
