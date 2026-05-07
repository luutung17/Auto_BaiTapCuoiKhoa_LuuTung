package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapCountry {
    public static void getElement(WebDriver driver, String country) {
        WebElement elementCountry= driver.findElement(By.xpath("//*[@id=\"Country\"]"));
        elementCountry.sendKeys(country);


    }
}
