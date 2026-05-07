package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapCompany {
    public static void getElement(WebDriver driver, String company) {
        WebElement elementCompany = driver.findElement(By.xpath("//input[@id=\"Company\"]"));
        elementCompany.sendKeys(company);


    }
}
