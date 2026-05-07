package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapFirstName {
    public static void getElement(WebDriver driver, String firstName) {
        WebElement elementFirstName = driver.findElement(By.name("FirstName"));
        elementFirstName.sendKeys(firstName);
    }
}
