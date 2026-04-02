import java.util.Scanner;

public class Main {

    void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int soCongDan = inputInt("Bạn muốn nhập thông tin của bao nhiêu công dân: ", input);
        for (int i = 1; i <= soCongDan; i++) {
            System.out.println("Vui lòng nhập thông tin của công dân số:" + i);
            congDan cd1 = new congDan();
            cd1 = cd1.nhapThongTin();
            System.out.println("Thông tin của công dân số: " + i);
            cd1.hienThongTin();
        }
    }

    public static int inputInt(String promt, Scanner in) {
        int value = 0;
        boolean ktra = false;
        do {
            try {
                System.out.printf(promt);
                value = Integer.parseInt(in.nextLine());
                ktra = true;
            } catch (Exception e) {
                System.out.println("Nhập sai dữ liệu, vui lòng nhập lại !");
            }
        } while (!ktra);
        return value;

    }

}


