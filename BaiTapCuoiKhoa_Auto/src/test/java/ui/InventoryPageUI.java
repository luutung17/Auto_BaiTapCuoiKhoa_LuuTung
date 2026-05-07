package ui;

import org.openqa.selenium.By;

public class InventoryPageUI {
    public static final By HEADERLABLE_FIELD = By.xpath("//*[@id=\"menu_button_container\"]/following-sibling::div[@class=\"header_label\"]/div[@class=\"app_logo\"]");
    public static final By MENU_FIELD = By.cssSelector("[class=\"bm-menu-wrap\"][aria-hidden=\"false\"]");
    public static final By ALL_ITEMS = By.cssSelector("[data-test='inventory-sidebar-link']");
    public static final By OPEN_MENU=By.xpath("//button[@id=\"react-burger-menu-btn\"]");
    public static final By ABOUT = By.cssSelector("[data-test='about-sidebar-link']");

    public static final By LOGOUT = By.cssSelector("[data-test='logout-sidebar-link']");

    public static final By RESET = By.cssSelector("[data-test='reset-sidebar-link']");
    public static final By AZ = By.cssSelector("[value='az']");
    public static final By ZA= By.cssSelector("[value='za']");
    public static final By LOHI= By.cssSelector("[value='lohi']");
    public static final By HILO= By.cssSelector("[value='hilo']");
    public static final By PRODUCTS= By.cssSelector(".inventory_item");
    public static final By IMG= By.cssSelector(".inventory_item_img");
    public static final By NAME= By.cssSelector(".inventory_item_name");
    public static final By DESC= By.cssSelector(".inventory_item_desc");
    public static final By PRICE= By.cssSelector(".inventory_item_price");
    public static final By BUTTON= By.cssSelector("button");
    public static final By DETAILS_NAME= By.cssSelector(".inventory_details_name");
    public static final By DETAILS_CONTAINER= By.cssSelector(".inventory_details_container");
    // ===== CART =====
    public static final By CART_ICON = By.cssSelector(".shopping_cart_link");
    public static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    public static final By CART_PAGE = By.cssSelector(".cart_list");

    // ===== SORT =====

    public static final By SORT_DROPDOWN = By.cssSelector("[data-test='product-sort-container']");

    public static final By SORT_AZ = By.cssSelector("[value='az']");

    public static final By SORT_ZA = By.cssSelector("[value='za']");

    public static final By SORT_LOHI = By.cssSelector("[value='lohi']");
    public static final By FIRST_NAME= By.id("first-name");
    public static final By SORT_HILO = By.cssSelector("[value='hilo']");
    public static final By REMOVE_BACKPACK= By.cssSelector("[id='remove-sauce-labs-backpack']");
    public static final By REMOVE_TSHIRT= By.cssSelector("[id='remove-sauce-labs-bolt-t-shirt']");
    public static final By ADDTOCART_BACKPACK= By.cssSelector("[name='add-to-cart-sauce-labs-backpack']");
    public static final By ADDTOCART_TSHIRT= By.cssSelector("[name='add-to-cart-sauce-labs-bolt-t-shirt']");
    public static final By PRODUCT_1 = By.id("item_4_title_link");
    public static final By PRODUCT_2 = By.id("item_1_title_link");
    public static final By PRODUCT_DESC =By.xpath("ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']");
    public static final By PRODUCT_PRICE= By.xpath("ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");

}
