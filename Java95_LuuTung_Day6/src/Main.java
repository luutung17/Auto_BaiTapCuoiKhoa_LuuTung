import java.lang.classfile.instruction.SwitchCase;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        MatHang[] ds = new MatHang[n];
        ds[0] = new MatHang("MH01", "Bánh", 20, 5000);
        ds[1] = new MatHang("MH02", "Kẹo", 50, 2000);
        ds[2] = new MatHang("MH03", "Sữa", 30, 15000);
        ds[3] = new MatHang("MH04", "Nước", 40, 10000);
        ds[4] = new MatHang("MH05", "Mì", 60, 3000);
        PhieuMuaHang[] ps = new PhieuMuaHang[1];
        ps[0] = new PhieuMuaHang("MP1", "Lưu Tùng", "086123456", "Hà Nội", 2);
        System.out.printf("\n%-10s %-15s %-10s %-10s", "Mã hàng", "Tên Hàng", "Số Lượng", "Đơn giá");
        for (int i = 0; i < n; i++) {
            System.out.printf("\n" + ds[i].hienThi());
        }
        for (int i = 0; i < ps.length; i++) {
            System.out.printf("\n===================================");
            System.out.printf("\n" + ps[i].hienThi());
        }
        Scanner input = new Scanner(System.in);
        System.out.printf("\n===================================");
        System.out.println("\nNếu bạn muốn sửa thông tin vui lòng lựa chọn các phương án sau: ");
        System.out.println("1. Sửa các thông tin phiếu mua hàng gồm: Họ tên, điện thoại, địa chỉ ");
        System.out.println("2. Sửa thông tin của mặt hàng ");
        System.out.println("0 hoặc các phím bất kỳ để kết thúc");
        System.out.println("Lưu ý: nếu bạn để trống thì sẽ giữ nguyên giá trị ban đầu");
        System.out.printf("Vui lòng lựa chọn: ");
        int luaChon;
        luaChon = input.nextInt();
        input.nextLine();
        switch (luaChon) {
            case 1:
                System.out.println("\nSửa họ tên:");
                String hoTen = input.nextLine();
                if (!hoTen.isEmpty()) {
                    ps[0].setHoTen(hoTen);
                }

                System.out.println("Sửa số điện thoại:");
                String soDienThoai = input.nextLine();
                if (!soDienThoai.isEmpty()) {
                    ps[0].setSoDienThoai(soDienThoai);
                }

                System.out.println("Sửa địa chỉ:");
                String diaChi = input.nextLine();
                if (!diaChi.isEmpty()) {
                    ps[0].setDiaChi(diaChi);
                }
                for (int i = 0; i < ps.length; i++) {
                    System.out.printf("\n===================================");
                    System.out.printf("\n" + ps[i].hienThi());
                }
                break;
            case 2:
                System.out.println("Vui lòng nhập mã hàng bạn muốn sửa:");
                String maHang = input.nextLine();

                boolean found = false;

                for (int i = 0; i < ds.length; i++) {

                    if (ds[i].getMaHang().equalsIgnoreCase(maHang)) {
                        found = true;
                        System.out.println("Sửa tên hàng (Enter để giữ nguyên):");
                        String tenHang = input.nextLine();
                        if (!tenHang.isEmpty()) {
                            ds[i].setTenHang(tenHang);
                        }
                        System.out.println("Sửa số lượng (Enter để giữ nguyên):");
                        String soLuongStr = input.nextLine();
                        if (!soLuongStr.isEmpty()) {
                            int soLuong = Integer.parseInt(soLuongStr);
                            ds[i].setSoLuong(soLuong);
                        }

                        System.out.println("Sửa đơn giá (Enter để giữ nguyên):");
                        String donGiaStr = input.nextLine();
                        if (!donGiaStr.isEmpty()) {
                            double donGia = Double.parseDouble(donGiaStr);
                            ds[i].setDonGia(donGia);
                        }
                        System.out.printf("\n%-10s %-15s %-10s %-10s",
                                "Mã hàng", "Tên Hàng", "Số Lượng", "Đơn giá");
                        System.out.printf("\n" + ds[i].hienThi());
                        break;
                    }
                }
                if(!found){
                    System.out.println("Không tìm thấy mã hàng!");
                }

            default:
                System.out.println("\nKết thúc !");
        }
    }
}
