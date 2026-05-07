package ui;

import org.openqa.selenium.By;

public class CheckOutPageUI {

    // ===== STEP 1: YOUR INFORMATION =====
    public static final By FIRST_NAME =
            By.id("first-name");

    public static final By LAST_NAME =
            By.id("last-name");

    public static final By POSTAL_CODE =
            By.id("postal-code");

    public static final By CONTINUE_BTN =
            By.id("continue");

    public static final By CANCEL_BTN =
            By.id("cancel");

    public static final By ERROR_MESSAGE =
            By.cssSelector("[data-test='error']");

    // ===== STEP 2 =====
    public static final By FINISH_BTN =
            By.id("finish");

    // ===== COMMON =====
    public static final By CART_PAGE =
            By.cssSelector(".cart_list");

    public static final By CHECKOUT_STEP_TWO =
            By.cssSelector(".checkout_summary_container");
}