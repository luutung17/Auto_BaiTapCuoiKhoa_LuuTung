package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapLastName {
    public static void getElement(WebDriver driver, String lastName) {
        WebElement elementName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
        elementName.sendKeys(lastName);
    }
}
