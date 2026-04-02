import java.util.Scanner;
import java.util.Arrays;

public class Main {
    //Bài 2:
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = nhapSoLuong(input);
        String[] words = nhapDanhSachTu(n, input);

        hienThiDanhSach(words);

        kiemTraTu(words, input);

        sapXepDanhSach(words);

        System.out.println("\nDanh sách sau khi sắp xếp:");
        hienThiDanhSach(words);

        input.close();
    }

    public static int nhapSoLuong(Scanner input) {
        System.out.print("Nhập số lượng từ: ");
        return input.nextInt();
    }

    public static String[] nhapDanhSachTu(int n, Scanner input) {
        input.nextLine(); // bỏ dòng trống
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập từ thứ " + (i + 1) + ": ");
            words[i] = input.nextLine();
        }

        return words;
    }

    public static void hienThiDanhSach(String[] words) {
        System.out.println("\nDanh sách từ:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void kiemTraTu(String[] words, Scanner input) {
        System.out.print("\nNhập từ cần kiểm tra: ");
        String tuCanTim = input.nextLine();

        boolean timThay = false;

        for (String word : words) {

            if (word.equalsIgnoreCase(tuCanTim)) {
                timThay = true;
                break;
            }
        }

        if (timThay) {
            System.out.println("Từ này có trong danh sách.");
        } else {
            System.out.println("Từ này KHÔNG có trong danh sách.");
        }
    }

    public static void sapXepDanhSach(String[] words) {
        Arrays.sort(words);
    }
}