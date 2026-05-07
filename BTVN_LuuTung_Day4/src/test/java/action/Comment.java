package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Comment {
    public static void getElement(WebDriver driver, String comment) {
        WebElement elementComments= driver.findElement(By.xpath("//*[@id=\"Sales_Contact_Comments__c\"]"));
        elementComments.sendKeys(comment);


    }
}
