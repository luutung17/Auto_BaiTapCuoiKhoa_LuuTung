package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapPhone {
    public static void getElement(WebDriver driver, String phone) {

        WebElement elementPhone= driver.findElement(By.xpath("//*[@id=\"Phone\"]"));
        elementPhone.sendKeys(phone);


    }
}
