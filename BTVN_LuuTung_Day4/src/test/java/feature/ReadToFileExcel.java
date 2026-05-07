package feature;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ReadToFileExcel {

    public static void main(String[] args) {
        try (FileInputStream file = new FileInputStream("dataGuiBieuMau.xlsx");
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheetDataLogin = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            // Đọc dữ liệu từ file Excel
            for (Row row : sheetDataLogin) {
                if (row.getRowNum() == 0) continue; // Bỏ qua hàng tiêu đề

                // Lấy giá trị từ cột "user" (cột 0) và "pass" (cột 1)
                String email = dataFormatter.formatCellValue(row.getCell(0)).trim();
                String FirstName = dataFormatter.formatCellValue(row.getCell(1)).trim();
                String LastName = dataFormatter.formatCellValue(row.getCell(2)).trim();
                String Company = dataFormatter.formatCellValue(row.getCell(3)).trim();
                String Phone = dataFormatter.formatCellValue(row.getCell(4)).trim();
                String Country = dataFormatter.formatCellValue(row.getCell(5)).trim();
                String value = dataFormatter.formatCellValue(row.getCell(6)).trim();
                String Comment = dataFormatter.formatCellValue(row.getCell(7)).trim();

                // In ra chỉ khi cả "user" và "pass" không rỗng
                if (!email.isEmpty() ) {
                    System.out.println("User: " + email);
                }
                //
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file Excel: " + e.getMessage());
        }
    }

}
