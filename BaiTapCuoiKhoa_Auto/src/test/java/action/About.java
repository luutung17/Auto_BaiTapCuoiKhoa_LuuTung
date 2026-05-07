package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.InventoryPageUI;

public class About {
    public static void Click(WebDriver driver) {
        WebElement elementAbout= driver.findElement(InventoryPageUI.ABOUT);
        elementAbout.click();
    }
}
