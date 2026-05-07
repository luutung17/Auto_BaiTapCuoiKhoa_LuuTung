package ui;

import org.openqa.selenium.By;

public class CheckOut_OverviewPageUI {

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


    // ===== COMMON =====
    public static final By CART_PAGE =
            By.cssSelector(".cart_list");

    public static final By CHECKOUT_STEP_TWO =
            By.cssSelector(".checkout_summary_container");
    public static final By OVERVIEW_PRODUCT_NAME =
            By.className("inventory_item_name");

    public static final By ITEM_TOTAL =
            By.className("summary_subtotal_label");

    public static final By TOTAL_PRICE =
            By.className("summary_total_label");

    public static final By FINISH_BTN =
            By.id("finish");

    // ===== COMPLETE =====
    public static final By COMPLETE_MESSAGE =
            By.className("complete-header");

}