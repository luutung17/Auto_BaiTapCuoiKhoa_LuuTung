package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.InventoryPageUI;

public class OpenMenu {
    public static void Click(WebDriver driver) {
        WebElement elementOpenMenu= driver.findElement(InventoryPageUI.OPEN_MENU);
        elementOpenMenu.click();
    }
}
