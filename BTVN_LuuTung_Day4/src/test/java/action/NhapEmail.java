package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NhapDuLieu {
    public static void getElement(WebDriver driver, String username, String password) {
        WebElement elementEmail = driver.findElement(By.id("Email"));
        WebElement elementFirstName = driver.findElement(By.name("FirstName"));
        WebElement elementName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
        WebElement elementCompany = driver.findElement(By.xpath("//input[@id=\"Company\"]"));
        WebElement elementPhone= driver.findElement(By.xpath("//*[@id=\"Phone\"]"));
        WebElement elementCountry= driver.findElement(By.xpath("//*[@id=\"Country\"]"));
        WebElement elementVN= driver.findElement(By.xpath("//*[@id=\"Country\"]/option[194]"));
        WebElement elementInterest = driver.findElement(By.xpath("//select[@id=\"Solution_Interest__c\"]"));
        WebElement optionInterest= driver.findElement(By.xpath("//*[@id=\"Solution_Interest__c\"]/option[2]"));
        WebElement elementComments= driver.findElement(By.xpath("//*[@id=\"Sales_Contact_Comments__c\"]"));
        WebElement elementTick= driver.findElement(By.xpath("//*[@id=\"LblmktoCheckbox_47709_0\"]"));
        WebElement elementLetTalk= driver.findElement(By.xpath("//button[text()=\"Let's Talk\"]"));
        
    }
}
