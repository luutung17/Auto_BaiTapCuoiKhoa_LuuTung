import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        HocSinh hs1 = new HocSinh();
        hs1 = hs1.nhapThongTin(input);
        hs1.hienThongTin();
    }
}