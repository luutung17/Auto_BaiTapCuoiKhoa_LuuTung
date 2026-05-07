package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {
    public static void Click(WebDriver driver,String elementProduct) {
        WebElement elementAddToCart= driver.findElement(By.cssSelector(elementProduct));
        elementAddToCart.click();
    }
}
