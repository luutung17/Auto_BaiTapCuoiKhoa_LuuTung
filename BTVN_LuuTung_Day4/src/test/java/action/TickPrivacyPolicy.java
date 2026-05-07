package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TickPrivacyPolicy {
    public static void getElement(WebDriver driver) {
        WebElement elementTick= driver.findElement(By.xpath("//*[@id=\"LblmktoCheckbox_47937_0\"]"));
        elementTick.click();
    }
}
