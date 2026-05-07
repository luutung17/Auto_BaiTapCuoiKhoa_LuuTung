package feature;

import action.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ExcelUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NguoiDungNhapBieuMauThanhCongTest {
    private static final String EXCEL_PATH = "src/test/java/data/dataGuiBieuMau.xlsx";
    private static final String SHEET_NAME = "Sheet1";
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        List<Map<String,String >> testData= ExcelUtils.readExcelData(EXCEL_PATH,SHEET_NAME);
        try{
            for (Map<String,String> row:testData){
                driver.get("https://saucelabs.com/request-demo");
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                driver.manage().window().maximize();
                NhapEmail.getElement(driver, row.get("Email"));
                NhapFirstName.getElement(driver, row.get("FirstName"));
                NhapLastName.getElement(driver, row.get("LastName"));
                NhapCompany.getElement(driver, row.get("Company"));
                NhapPhone.getElement(driver, row.get("Phone"));
                NhapCountry.getElement(driver, row.get("Country"));
                ChonInterest.getElement(driver, row.get("Value"));
                Comment.getElement(driver, row.get("Comment"));
                TickPrivacyPolicy.getElement(driver);
                ClickButtonGuiBieuMau.clickButton(driver);
                System.out.println("Đã thực hiện nhập biểu mẫu cho email: "+row.get("Email"));
            }
        }finally {
            driver.quit();
        }
//        WebElement elementLetTalk= driver.findElement(By.xpath("//button[text()=\"Let's Talk\"]"));
//        elementLetTalk.click();
//        String currentUrl = driver.getCurrentUrl();
//        if(currentUrl.contains("thank-you-contact")){
//            System.out.println("Test Passed");
//        }else{
//            System.out.println("Test Failed");
//        }
        driver.quit();
    }
}

