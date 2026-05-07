import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        int sumHocVien = 10;
        HocVien[] danhSach = new HocVien[sumHocVien];
        danhSach[0] = new HocVien("HV01", "Nguyen Van A", "0900000001", "15/01/2009", "07/01/2026", "Java", 3000000);
        danhSach[1] = new HocVien("HV02", "Tran Thi B", "0900000002", "02/01/2026", "02/01/2026", "Python", 2800000);
        danhSach[2] = new HocVien("HV03", "Le Van C", "0900000003", "02/01/2026", "03/01/2026", "C++", 2500000);
        danhSach[3] = new HocVien("HV04", "Pham Thi D", "0900000004", "02/01/2026", "04/01/2026", "Java", 3000000);
        danhSach[4] = new HocVien("HV05", "Hoang Van E", "0900000005", "02/01/2026", "05/01/2026", "Web", 3500000);
        danhSach[5] = new HocVien("HV06", "Nguyen Thi F", "0900000006", "02/01/2026", "06/01/2026", "Java", 3000000);
        danhSach[6] = new HocVien("HV07", "Tran Van G", "0900000007", "02/01/2026", "07/01/2026", "Python", 2800000);
        danhSach[7] = new HocVien("HV08", "Le Thi H", "0900000008", "02/01/2026", "08/01/2026", "C#", 3200000);
        danhSach[8] = new HocVien("HV09", "Pham Van I", "0900000009", "02/01/2026", "09/01/2026", "SQL", 2700000);
        danhSach[9] = new HocVien("HV10", "Hoang Thi K", "0900000010", "02/01/2026", "10/01/2026", "SQL", 2600000);
        System.out.printf("Vui lòng chọn chương trình bạn muốn tham gia: ");
        Scanner input = new Scanner(System.in);
        int menu = input.nextInt();
        input.nextLine();
        switch (menu) {
            case 1:

                System.out.println("Nhập mã học viên:");
                String ma = input.nextLine();

                while (timKiemTheoMa(danhSach, sumHocVien, ma) != null) {
                    System.out.println("Mã học viên đã bị trùng, vui lòng nhập lại:");
                    ma = input.nextLine();
                }

                System.out.println("Nhập tên:");
                String ten = input.nextLine();
                while (ten.isEmpty()) {
                    System.out.println("Vui lòng không để trống!");
                    ten = input.nextLine();
                }

                System.out.println("Nhập số điện thoại:");
                String sdt;

                while (true) {
                    sdt = input.nextLine();

                    if (sdt.matches("\\d{10}")) {
                        break;
                    } else {
                        System.out.println("Số điện thoại không hợp lệ! Vui lòng nhập lại (10 số):");
                    }
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String ngaySinh;

                while (true) {

                    System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
                    ngaySinh = input.nextLine();

                    try {

                        LocalDate ngay1 = LocalDate.parse(ngaySinh, formatter);

                        if (ngay1.plusYears(18).isAfter(LocalDate.now())) {
                            System.out.println("Chưa đủ 18 tuổi!");
                            continue;
                        }

                        break;

                    } catch (Exception e) {
                        System.out.println("Ngày không hợp lệ!");
                    }
                }

                String ngayDangKy;

                while (true) {

                    System.out.println("Nhập ngày đăng ký (dd/MM/yyyy):");
                    ngayDangKy = input.nextLine();

                    try {
                        LocalDate.parse(ngayDangKy, formatter);
                        break;
                    } catch (Exception e) {
                        System.out.println("Ngày không hợp lệ!");
                    }
                }

                System.out.println("Nhập tên khóa học:");
                String khoa = input.nextLine();

                System.out.println("Nhập học phí:");
                double hocPhi = input.nextDouble();

                while (hocPhi < 0) {
                    System.out.println("Học phí không được âm:");
                    hocPhi = input.nextDouble();
                }

                input.nextLine();

                danhSach[sumHocVien] = new HocVien(ma, ten, sdt, ngaySinh, ngayDangKy, khoa, hocPhi);

                sumHocVien++;

                System.out.println("Thêm học viên thành công!");

                break;
            case 2:
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.printf("%-10s %-20s %-15s %-15s %-20s %-10s\n",
                        "MaHV", "Ten", "SoDT", "NgayDK", "KhoaHoc", "HocPhi");
                System.out.println("------------------------------------------------------------------------------------------------");

                for (int i = 0; i < sumHocVien; i++) {
                    System.out.printf("%-10s %-20s %-15s %-15s %-20s %-10.2f\n",
                            danhSach[i].maHocVien,
                            danhSach[i].ten,
                            danhSach[i].soDienThoai,
                            danhSach[i].ngayDangKy,
                            danhSach[i].tenKhoaHoc,
                            danhSach[i].hocPhi);
                }

                System.out.println("------------------------------------------------------------------------------------------------");
                break;
            case 3:

                input.nextLine();
                System.out.println("Vui lòng nhập mã học viên:");
                String maHV = input.nextLine();

                HocVien hv = timKiemTheoMa(danhSach, sumHocVien, maHV);

                if (hv == null) {
                    System.out.println("Không tìm thấy học viên");
                } else {
                    System.out.println("Thông tin học viên:");
                    hv.hienThiThongTin();
                }

                break;
            case 4:
                timKiemTheoTen(danhSach, sumHocVien, input);
                break;
            case 5:

                input.nextLine();
                System.out.println("Nhập mã học viên cần sửa:");
                String maHV1 = input.nextLine();

                HocVien hv1 = timKiemTheoMa(danhSach, sumHocVien, maHV1);

                if (hv1 == null) {
                    System.out.println("Không tìm thấy học viên!");
                } else {

                    System.out.println("Tên hiện tại: " + hv1.ten);
                    System.out.print("Nhập tên mới (Enter để giữ nguyên): ");
                    String tenMoi = input.nextLine();
                    if (!tenMoi.isEmpty()) {
                        hv1.ten = tenMoi;
                    }

                    System.out.println("SĐT hiện tại: " + hv1.soDienThoai);
                    System.out.print("Nhập SĐT mới (Enter để giữ nguyên): ");
                    String sdtMoi = input.nextLine();
                    if (!sdtMoi.isEmpty()) {
                        hv1.soDienThoai = sdtMoi;
                    }
                    System.out.println("Ngày đăng sinh: " + hv1.ngaySinh);
                    System.out.print("Nhập ngày sinh mới (Enter để giữ nguyên): ");
                    String ngaySinhMoi = input.nextLine();
                    if (!ngaySinhMoi.isEmpty()) {
                        hv1.ngayDangKy = ngaySinhMoi;
                    }

                    System.out.println("Ngày đăng ký hiện tại: " + hv1.ngayDangKy);
                    System.out.print("Nhập ngày đăng ký mới (Enter để giữ nguyên): ");
                    String ngayMoi = input.nextLine();
                    if (!ngayMoi.isEmpty()) {
                        hv1.ngayDangKy = ngayMoi;
                    }

                    System.out.println("Khóa học hiện tại: " + hv1.tenKhoaHoc);
                    System.out.print("Nhập khóa học mới (Enter để giữ nguyên): ");
                    String khoaMoi = input.nextLine();
                    if (!khoaMoi.isEmpty()) {
                        hv1.tenKhoaHoc = khoaMoi;
                    }

                    System.out.println("Học phí hiện tại: " + hv1.hocPhi);
                    System.out.print("Nhập học phí mới (Enter để giữ nguyên): ");
                    String hocPhiMoi = input.nextLine();

                    if (!hocPhiMoi.isEmpty()) {
                        hv1.hocPhi = Double.parseDouble(hocPhiMoi);
                    }

                    System.out.println("Cập nhật thành công!");
                }

                break;
            case 6:
                input.nextLine();
                System.out.println("Vui lòng nhập mã học viên:");
                String maHV2 = input.nextLine();

                HocVien hv2 = timKiemTheoMa(danhSach, sumHocVien, maHV2);
                int viTri = -1;
                for (int i = 0; i < sumHocVien; i++) {
                    if (maHV2.equalsIgnoreCase(danhSach[i].maHocVien)) {
                        viTri = i;
                        break;
                    }
                }
                if (hv2 == null) {
                    System.out.println("Không tìm thấy học viên");
                } else {
                    System.out.println("Thông tin học viên:");
                    hv2.hienThiThongTin();
                    System.out.println("Bạn có chắc chắn muốn xóa! (Bấm phím 1 để đồng ý và 2 để hủy");
                    int xacNhan = input.nextInt();
                    if (xacNhan == 1) {
                        for (int i = viTri; i < sumHocVien - 1; i++) {
                            danhSach[i] = danhSach[i + 1];
                        }
                        sumHocVien--;
                        System.out.println("Xóa học viên thành công!");
                    } else {
                        System.out.println("Cảm ơn đã hủy !");
                    }
                }
            case 7:
                sapXepTheoNgay(danhSach, sumHocVien);

                break;
            case 8:

                int python = 0;
                int java = 0;
                int cpp = 0;
                int csharp = 0;
                int sql = 0;

                for (int i = 0; i < sumHocVien; i++) {

                    switch (danhSach[i].tenKhoaHoc.toLowerCase()) {

                        case "python":
                            python++;
                            break;

                        case "java":
                            java++;
                            break;

                        case "c++":
                            cpp++;
                            break;

                        case "c#":
                            csharp++;
                            break;

                        case "sql":
                            sql++;
                            break;
                    }
                }

                System.out.println("===== THỐNG KÊ KHÓA HỌC =====");
                System.out.println("Python: " + python);
                System.out.println("Java: " + java);
                System.out.println("C++: " + cpp);
                System.out.println("C#: " + csharp);
                System.out.println("SQL: " + sql);

                break;
        }
    }

    public static HocVien timKiemTheoMa(HocVien[] danhSach, int sumHocVien, String maHV) {

        for (int i = 0; i < sumHocVien; i++) {
            if (maHV.equalsIgnoreCase(danhSach[i].maHocVien)) {
                return danhSach[i];
            }
        }

        return null;
    }

    public static void timKiemTheoTen(HocVien[] danhSach, int sumHocVien, Scanner input) {

        input.nextLine();
        System.out.println("Vui lòng nhập tên học viên:");

        String tenTimKiem = input.nextLine().toLowerCase();
        boolean found = false;

        for (int i = 0; i < sumHocVien; i++) {

            if (danhSach[i].ten.toLowerCase().contains(tenTimKiem)) {
                System.out.println("------------------------------------");
                danhSach[i].hienThiThongTin();
                found = true;
            }

        }

        if (!found) {
            System.out.println("Không tìm thấy tên.");
        }
    }

    public static void sapXepTheoNgay(HocVien[] danhSach, int sumHocVien) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = 0; i < sumHocVien - 1; i++) {
            for (int j = i + 1; j < sumHocVien; j++) {

                LocalDate ngay1 = LocalDate.parse(danhSach[i].ngayDangKy, formatter);
                LocalDate ngay2 = LocalDate.parse(danhSach[j].ngayDangKy, formatter);

                if (ngay1.isAfter(ngay2)) {
                    HocVien temp = danhSach[i];
                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println("Danh sách học viên sau khi sắp xếp:");

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-15s %-20s %-10s\n",
                "MaHV", "Ten", "SoDT", "NgayDK", "KhoaHoc", "HocPhi");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (int i = 0; i < sumHocVien; i++) {
            System.out.printf("%-10s %-20s %-15s %-15s %-20s %-10.2f\n",
                    danhSach[i].maHocVien,
                    danhSach[i].ten,
                    danhSach[i].soDienThoai,
                    danhSach[i].ngayDangKy,
                    danhSach[i].tenKhoaHoc,
                    danhSach[i].hocPhi);
        }

        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
