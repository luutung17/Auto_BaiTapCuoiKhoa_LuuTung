import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("123");

        // Khai báo hằng + biến
        int tuoi = 15;
        int a,b,c;
        int d,e,f=0;
        //=> ten_kieu ten_bien = gia_tri
        float f0=3.14f;
        double d0=3.1416312312312;
        // Hằng: Dùng từ khóa final
        final int g=10;
        // Đặt tên biến
        // Đặt tên class (upper camel case: Main, HocSinh,...)
        // III. Nhập xuất cơ bản
        // 1. Xuất dữ liệu
        System.out.print("in trên 1 dòng");
        System.out.print("tiếp tục");
        System.out.println("in xuống dòng");
        // in có định dạng
        System.out.printf("\n biến f = %f", f0); //souf
        System.out.printf("\n bien a = %d",g);

        //int ngaySinh= input.nextInt();
        //System.out.println("ngày sinh của bạn là: " +ngaySinh);
        // %f dùng cho số thực
        // %d dùng cho số nguyên
        // %c in ký tự
        // %s in chuỗi (string)
        // => dùng souf
        System.out.printf("\n data: %10d",1);
        System.out.printf("\n data: %10d",123);
        System.out.printf("\n tên: %-17s %3d", "Lưu Văn Tùng", 23);
        System.out.printf("\n tên: %-17s %3d", "Lưu Văn ", 5);
        System.out.printf("\n tên: %-17s %3d", "Lưu Văn B", 23);
        System.out.printf("\n f=%5.3f",d0); //5.3f= động rộng =5. phần thập phân làm tròn 3 chữ số
        // Nhập dữ liệu
        Scanner input = new Scanner(System.in);
        System.out.println("\nNhập tên của bạn: ");
        String name = input.nextLine();
        // hiện tượng trôi lệnh xảy ra khi trước đó nhập số, sau đ chuển sang nhập chuỗi
        // xử lý: viết riêng một lệnh nextLine sc.nextLine();
        int number = inputInt("Hãy nhập một số: ", input);
        input.nextLine();

    }
    public static int inputInt(String promt, Scanner sc){
        int in =-1;
        do {
            try{
                System.out.println(promt);
                in = Integer.parseInt(sc.nextLine());
            }catch (Exception e) {
                System.out.println("Số không hợp lệ");
            }
        } while (in == -1);

        return in;
    }
}
