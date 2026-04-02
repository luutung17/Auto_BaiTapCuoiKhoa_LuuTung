public class MatHang {
    String maHang;
    String tenHang;
    int soLuong;
    double donGia;

    // Constructor
    public MatHang(String maHang, String tenHang, int soLuong, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Hiển thị thông tin
    public String hienThi() {
        return String.format("%-10s %-15s %-10s %-10.2s",
                maHang, tenHang, soLuong, donGia);
    }

    public String getMaHang() {
        return maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}