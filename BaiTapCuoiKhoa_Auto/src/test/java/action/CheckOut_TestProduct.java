package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class About {
    public static void Click(WebDriver driver) {
        WebElement elementAbout= driver.findElement(By.cssSelector("[data-test=\"about-sidebar-link\"]"));
        elementAbout.click();
    }
}
