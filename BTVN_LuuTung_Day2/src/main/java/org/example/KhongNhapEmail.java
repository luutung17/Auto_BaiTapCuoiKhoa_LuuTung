package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KhongNhapEmail {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://saucelabs.com/request-demo");

        // KHÔNG nhập email

        driver.findElement(By.name("FirstName")).sendKeys("Luu");
        driver.findElement(By.id("LastName")).sendKeys("Tung");
        driver.findElement(By.id("Company")).sendKeys("LG");
        driver.findElement(By.id("Phone")).sendKeys("0862420650");

        driver.findElement(By.id("Country")).click();
        driver.findElement(By.xpath("//*[@id='Country']/option[194]")).click();

        driver.findElement(By.id("Solution_Interest__c")).click();
        driver.findElement(By.xpath("//*[@id='Solution_Interest__c']/option[2]")).click();

        driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys("Test validation");

        // Click submit
        driver.findElement(By.xpath("//button[text()=\"Let's Talk\"]")).click();

        Thread.sleep(3000);

        // Kiểm tra message lỗi
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[contains(text(),'valid email')]")
        );

        if(errorMessage.isDisplayed()){
            System.out.println("Test Passed - Email validation works");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();
    }
}
