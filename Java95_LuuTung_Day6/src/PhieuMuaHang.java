public class PhieuMuaHang {
    String maPhieu;
    String hoTen;
    String soDienThoai;
    String diaChi;
    int soMatHang;

    public PhieuMuaHang(String maPhieu, String hoTen, String soDienThoai, String diaChi, int soMatHang) {
        this.maPhieu=maPhieu;
        this.hoTen=hoTen;
        this.soDienThoai=soDienThoai;
        this.diaChi=diaChi;
        this.soMatHang=soMatHang;
    }

    public String hienThi() {
        return "\nMã Phiếu: " + maPhieu +
                "\nHọ tên" + hoTen +
                "\nSố điện thoại: " + soDienThoai +
                "\nĐịa chỉ: " + diaChi +
                "\nSố mặt hàng:" + soMatHang;
    }
    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }
    public void setSoDienThoai(String soDienThoai){
        this.soDienThoai=soDienThoai;
    }
    public void setDiaChi(String diaChi){
        this.diaChi=diaChi;
    }

}
