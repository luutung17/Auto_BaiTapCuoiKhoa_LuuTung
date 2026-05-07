package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {

    public static void Click(WebDriver driver, By locator) {
        WaitElement.Wait(driver, locator);
        driver.findElement(locator).click();
    }
}
