package feature;

import action.AddToCart;
import action.CheckOut_TestProduct;
import action.LoginAction;
import action.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class CheckOut_OverView {
    WebDriver driver;

    @BeforeClass //mtw1 lần
    public void beforeClass() {
        System.out.println("=== @BeforeClass: Khởi tạo Driver - Chạy trước các method trong class này ===");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("=== @BeforeMethod: Mở trang web - Chạy trước mỗi test case (@Test) ===");
        driver.get("https://www.saucedemo.com/");
        LoginAction.performLogin(driver, "standard_user", "secret_sauce");
    }



    @Test
    public void test() {

        System.out.println("--- Test Continue Shopping ---");


        AddToCart.Click(driver, "[name='add-to-cart-sauce-labs-backpack']");
        CheckOut_TestProduct.Click(driver);

        WaitElement.Wait(driver, "#continue-shopping");


        driver.findElement(By.id("continue-shopping")).click();


        WaitElement.Wait(driver, ".inventory_list");

        org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Did not navigate back to inventory page!");
    }




    @AfterClass
    public void afterClass() {
        System.out.println("=== @AfterClass: Đóng Driver - Chạy sau tất cả các method trong class này ===");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("=== @AfterSuite: Chạy cuối cùng, sau tất cả các test trong suite ===");
    }
}
