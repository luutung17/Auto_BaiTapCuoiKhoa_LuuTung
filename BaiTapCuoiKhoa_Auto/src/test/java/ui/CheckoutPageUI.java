package ui;

import org.openqa.selenium.By;

public class CheckoutPageUI {

    // ===== CART PAGE =====
    public static final By CART_ITEM =
            By.cssSelector(".cart_item");

    public static final By CART_ITEM_NAME =
            By.cssSelector(".inventory_item_name");

    public static final By CART_ITEM_DESC =
            By.cssSelector(".inventory_item_desc");

    public static final By CART_ITEM_PRICE =
            By.cssSelector(".inventory_item_price");

    // ===== BUTTON =====
    public static final By REMOVE_BUTTON =
            By.cssSelector("button[id^='remove']");

    public static final By CONTINUE_SHOPPING_BTN =
            By.id("continue-shopping");

    public static final By CHECKOUT_BTN =
            By.id("checkout");

    public static final By INVENTORY_LIST =
            By.cssSelector(".inventory_list");
    public static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    public static final By FIRST_NAME= By.id("first-name");
}
