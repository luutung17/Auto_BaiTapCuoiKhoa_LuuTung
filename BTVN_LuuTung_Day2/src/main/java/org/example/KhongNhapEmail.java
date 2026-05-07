package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KhongNhapEmail {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucelabs.com/request-demo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement elementFirstName = driver.findElement(By.name("FirstName"));
        elementFirstName.sendKeys("Lưu Văn");
        WebElement elementName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
        elementName.sendKeys("Tùng");
        WebElement elementCompany = driver.findElement(By.xpath("//input[@id=\"Company\"]"));
        elementCompany.sendKeys("LG");
        WebElement elementPhone= driver.findElement(By.xpath("//*[@id=\"Phone\"]"));
        elementPhone.sendKeys("0862420650");
        WebElement elementCountry= driver.findElement(By.xpath("//*[@id=\"Country\"]"));
        elementCountry.click();
        WebElement elementVN= driver.findElement(By.xpath("//*[@id=\"Country\"]/option[194]"));
        elementVN.click();
        WebElement elementInterest = driver.findElement(By.xpath("//select[@id=\"Solution_Interest__c\"]"));
        elementInterest.click();
        WebElement optionInterest= driver.findElement(By.xpath("//*[@id=\"Solution_Interest__c\"]/option[2]"));
        optionInterest.click();
        WebElement elementComments= driver.findElement(By.xpath("//*[@id=\"Sales_Contact_Comments__c\"]"));
        elementComments.sendKeys("Điền thành công");
        WebElement elementTick= driver.findElement(By.xpath("//*[@id=\"LblmktoCheckbox_47709_0\"]"));
        elementTick.click();
        WebElement elementLetTalk= driver.findElement(By.xpath("//button[text()=\"Let's Talk\"]"));
        elementLetTalk.click();
        Thread.sleep(3000);

        // Kiểm tra message lỗi
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[text()=\"example@yourdomain.com\"]")
        );

        if(errorMessage.isDisplayed()){
            System.out.println("Test Passed - Email validation works");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
