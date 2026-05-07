package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.LoginPageUI;

public class LoginAction {
    public static void performLogin(WebDriver driver, String username, String password) {
        WebElement userInp = driver.findElement(LoginPageUI.USERNAME_FIELD);
        WebElement passInp = driver.findElement(LoginPageUI.PASSWORD_FIELD);
        WebElement loginBtn = driver.findElement(LoginPageUI.LOGINBUTTON_FIELD);

        userInp.sendKeys(username);
        passInp.sendKeys(password);
        loginBtn.click();
    }
}
