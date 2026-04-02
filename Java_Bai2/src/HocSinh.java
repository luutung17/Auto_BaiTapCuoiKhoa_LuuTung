import java.util.Scanner;

public class HocSinh {
    String maHS;
    String hoDem;
    String ten;
    String ngaySinh;
    String gioiTinh;
    double diemTBToan;
    double diemTBVan;
    double diemTBAnh;
    public static Double nhapDiemTb(String promt, Scanner input){
        Double in=0d;
        boolean value=false;
        do{
            try{
                System.out.printf(promt);
                in= Double.parseDouble(input.nextLine());
                value=true;
            } catch (Exception e) {
                System.out.println("Nhập sai dữ liệu vui lòng nhập lại!");
            }
        }while (!value);
        return in;
    }
    public static double tinhDiemTB(double a, double b, double c){
        return (a*2+b*2+c)/5;
    }
    public HocSinh nhapThongTin(Scanner input){
        HocSinh hs1=new HocSinh();
        System.out.print("Nhập mã học sinh: ");
        hs1.maHS = input.nextLine();

        System.out.print("Nhập họ đệm: ");
        hs1.hoDem = input.nextLine();

        System.out.print("Nhập tên: ");
        hs1.ten = input.nextLine();

        System.out.print("Nhập ngày sinh: ");
        hs1.ngaySinh = input.nextLine();

        System.out.print("Nhập giới tính: ");
        hs1.gioiTinh = input.nextLine();

        hs1.diemTBToan = nhapDiemTb("Nhập điểm trung bình Toán: ",input );
        hs1.diemTBVan = nhapDiemTb("Nhập điểm trung bình Văn : ",input );
        hs1.diemTBAnh = nhapDiemTb("Nhập điểm trung bình Anh: ",input );
        return hs1;
    }
    public void hienThongTin(){
        System.out.printf("%13s %-13s %-13s %-13s %-13s %13s","Mã học sinh","Họ đệm","Tên","Ngày sinh","Giới tính","Điểm trung bình");
        System.out.printf("\n%8s %-13s %-13s %-13s %-13s %13s", maHS,hoDem,ten,ngaySinh,gioiTinh,tinhDiemTB(diemTBToan,diemTBVan,diemTBAnh));
    }
}
