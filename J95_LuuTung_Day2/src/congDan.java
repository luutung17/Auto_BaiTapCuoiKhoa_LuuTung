import java.util.Scanner;

public class congDan {
    String canCuoc;
    String hoDem;
    String ten;
    String ngaySinh;
    String gioiTinh;
    String diaChi;
    String dienThoai;

    public congDan nhapThongTin() {
        congDan cd1 = new congDan();
        Scanner input = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.printf("\nNhập số căn cước công dân: ");
        cd1.canCuoc = input.nextLine();
        System.out.printf("\nNhập thông tin họ đệm: ");
        cd1.hoDem = input.nextLine();
        System.out.printf("\nNhập thông tin tên: ");
        cd1.ten = input.nextLine();
        System.out.printf("\nNhập thông tin ngày sinh: ");
        cd1.ngaySinh = input.nextLine();
        System.out.printf("\nNhập thông tin giới tính: ");
        cd1.gioiTinh = input.nextLine();
        System.out.printf("\nNhập thông tin địa chỉ: ");
        cd1.diaChi = input.nextLine();
        System.out.printf("\nNhập số điện thoại:");
        cd1.dienThoai = input.nextLine();
        System.out.println("==============================================");
        return cd1;
    }

    public void hienThongTin() {
        System.out.println("==============================================");
        System.out.printf("%-20s : %s\n", "Căn cước công dân", canCuoc);
        System.out.printf("%-20s : %s %s\n", "Họ và tên", hoDem, ten);
        System.out.printf("%-20s : %s\n", "Ngày sinh", ngaySinh);
        System.out.printf("%-20s : %s\n", "Giới tính", gioiTinh);
        System.out.printf("%-20s : %s\n", "Địa chỉ", diaChi);
        System.out.printf("%-20s : %s\n", "Số điện thoại", dienThoai);
        System.out.println("==============================================");

    }
}

