package feature;

import action.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import untils.ExcelUtils;

import java.util.List;
import java.util.Map;

public class ActionLoginPageTest {
    private static final String EXCEL_PATH = "dataLogin.xlsx";
    private static final String SHEET_NAME = "Sheet1";
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    public static void main(String[] args) {
        List<Map<String,String >> testData= ExcelUtils.readExcelData(EXCEL_PATH,SHEET_NAME);
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        try{
            for (Map<String,String> row:testData){
                driver.get(LOGIN_URL);
                LoginAction.performLogin(
                        driver,
                        row.get("Username"),
                        row.get("Password")
                );
                System.out.println("Đã thực hiện đăng nhập cho username: "+row.get("Username"));
            }
        }finally {
            driver.quit();
        }

    }
}
