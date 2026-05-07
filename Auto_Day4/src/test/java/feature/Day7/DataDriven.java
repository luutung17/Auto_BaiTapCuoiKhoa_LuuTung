package feature.Day7;
import action.LoginAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.LoginPageUI;
import untils.ExcelUtils;
import untils.Hook;

import java.util.List;
import java.util.Map;

public class DataDriven extends Hook {

    String excelFilePath = "dataLogin.xlsx";

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        List<Map<String, String>> excelData = ExcelUtils.readExcelData(excelFilePath, "Sheet1");
        Object[][] data = new Object[excelData.size()][1]; // Mỗi row là 1 Map<String, String>
        for (int i = 0; i < excelData.size(); i++) {
            data[i][0] = excelData.get(i);
        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(Map<String, String> rowData) {
        String username = rowData.get("Username");
        String password = rowData.get("Password");
        String expectedResult = rowData.get("ExpectedResult");

        LoginAction.performLogin(driver,username,password);


        if ("pass".equalsIgnoreCase(expectedResult)) {
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login failed unexpectedly!");
        } else if ("fail".equalsIgnoreCase(expectedResult)) {
            WebElement error = driver.findElement(LoginPageUI.ERROR_FIELD);
            Assert.assertTrue(error.isDisplayed(), "Expected error message not displayed!");
        } else {
            Assert.fail("ExpectedResult trong Excel phải là 'pass' hoặc 'fail'");
        }
    }
}
