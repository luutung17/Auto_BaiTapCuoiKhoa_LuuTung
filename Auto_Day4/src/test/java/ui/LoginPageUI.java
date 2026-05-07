package ui;

import org.openqa.selenium.By;

public class LoginPageUI {
    public static final By USERNAME_FIELD =By.id("user-name");
    public static final By PASSWORD_FIELD =By.id("password");
    public static final By LOGINBUTTON_FIELD=By.id("login-button");
    public static final By ERROR_FIELD=By.cssSelector("[data-test='error']");
}
