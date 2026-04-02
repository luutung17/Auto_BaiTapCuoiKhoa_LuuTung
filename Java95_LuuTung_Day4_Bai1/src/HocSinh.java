public class HocSinh {
    int id, toan, van, anh, tong;
    public int tinhTongDiem(){
        return toan + van + anh*2;
    }
    public String hienThi(){
        return "Thí sinh "+id+": "+"tổng điểm: "+tong;
    }
}
