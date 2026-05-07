package untils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Hook {
    protected WebDriver driver;
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
