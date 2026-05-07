package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapEmail {
    public static void getElement(WebDriver driver, String email) {
        WebElement elementEmail = driver.findElement(By.id("Email"));
        elementEmail.sendKeys(email);

    }
}
