public class HocVien {
    String maHocVien;
    String ten;
    String soDienThoai;
    String ngaySinh;
    String ngayDangKy;
    String tenKhoaHoc;
    double hocPhi;
    public HocVien(String maHocVien, String ten, String soDienThoai, String ngaySinh,
                   String ngayDangKy, String tenKhoaHoc, double hocPhi) {
        this.maHocVien = maHocVien;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.ngaySinh=ngaySinh;
        this.ngayDangKy = ngayDangKy;
        this.tenKhoaHoc = tenKhoaHoc;
        this.hocPhi = hocPhi;
    }
    // Hàm hiển thị thông tin
    public void hienThiThongTin() {
        System.out.println("Mã học viên: " + maHocVien);
        System.out.println("Tên học viên: " + ten);
        System.out.println("Số điện thoại: " + soDienThoai);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Ngày đăng ký: " + ngayDangKy);
        System.out.println("Tên khóa học: " + tenKhoaHoc);
        System.out.println("Học phí: " + hocPhi);
    }

}
