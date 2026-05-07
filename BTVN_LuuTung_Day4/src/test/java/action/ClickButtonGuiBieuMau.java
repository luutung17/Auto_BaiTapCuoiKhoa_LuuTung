package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickButtonGuiBieuMau {
    public static void clickButton(WebDriver driver) {
        WebElement elementTick= driver.findElement(By.xpath("//*[@id=\"mktoForm_3766\"]/div[@class=\"mktoButtonRow\"]/span[@class=\"mktoButtonWrap mktoSimple\"]/button"));
        elementTick.click();
    }
}
