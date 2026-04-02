import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Bài 4
        System.out.println("Xin mời nhập ba cạnh của tam giác !");
        Scanner input= new Scanner(System.in);
        double a= inputDouble("Nhập cạnh 1: ", input);
        double b= inputDouble("Nhập cạnh 2: ", input);
        double c= inputDouble("Nhập cạnh 3: ", input);
        double ChuViTamGiac= a+b+c;
        double p=ChuViTamGiac/2;
        double DienTichTamGiac = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.println("Chu vi của tam giác là: " + ChuViTamGiac);
        System.out.println("Diện tích của tam giác là: " + DienTichTamGiac);
        //Bài 5
        double chieudai= inputDouble("Nhập chiều dài hình hộp chữ nhập: ", input);
        double chieurong= inputDouble("Nhập chiều rộng hình hộp chữ nhập: ", input);
        double chieucao= inputDouble("Nhập chiều cao hình hộp chữ nhập: ", input);
        double DienTichXunhQuanh = 2 * chieucao * (chieudai + chieurong);
        double DienTichToanPhan = DienTichXunhQuanh + 2 * chieudai * chieurong;
        double TheTich = chieucao * chieurong * chieudai;
        System.out.println("Diện tích xung quanh là : " + DienTichXunhQuanh);
        System.out.println("Diện tích Toàn phần  là : " + DienTichToanPhan);
        System.out.println("Thể tích là : " + TheTich);
    }
    public static double inputDouble(String prompt, Scanner input) {
        double value = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(input.nextLine());
                isValid = true; // nhập đúng thì thoát vòng lặp
            } catch (NumberFormatException e) {
                System.out.println("Giá trị nhập không hợp lệ. Vui lòng nhập số thực!");
            }
        } while (!isValid);

        return value;
    }
}
