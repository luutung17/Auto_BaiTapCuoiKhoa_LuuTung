package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.InventoryPageUI;

public class SortProduct {
    public static void Click(WebDriver driver) {
        WebElement elementSortProduct= driver.findElement(InventoryPageUI.SORT_DROPDOWN);
        elementSortProduct.click();
    }
}
