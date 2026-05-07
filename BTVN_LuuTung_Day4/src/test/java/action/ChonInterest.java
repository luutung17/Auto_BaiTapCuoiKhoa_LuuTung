package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ChonInterest {
    public static void getElement(WebDriver driver, String value) {
        WebElement elementInterest = driver.findElement(By.xpath("//select[@id=\"Solution_Interest__c\"]"));
        Select oSelect = new Select(elementInterest);
        oSelect.selectByValue(value);
    }
}
