import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập số thí sinh muốn nhập điểm: ");
        n = input.nextInt();

        HocSinh[] hs = new HocSinh[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\n-------------------------------");

            hs[i] = new HocSinh();
            hs[i].id = i + 1;

            System.out.print("Nhập điểm Toán của thí sinh " + (i + 1) + ": ");
            hs[i].toan = input.nextInt();

            System.out.print("Nhập điểm Văn của thí sinh " + (i + 1) + ": ");
            hs[i].van = input.nextInt();

            System.out.print("Nhập điểm Anh của thí sinh " + (i + 1) + ": ");
            hs[i].anh = input.nextInt();

            System.out.println("Tổng điểm: " + hs[i].tinhTongDiem());
        }

        // Sắp xếp theo tổng điểm
        Arrays.sort(hs, (a, b) -> a.tinhTongDiem() - b.tinhTongDiem());

        // Hiển thị danh sách
        System.out.println("\n==============================================");
        System.out.println("Danh sách thí sinh sau khi sắp xếp theo tổng điểm");
        System.out.println("==============================================");

        System.out.printf("%-5s %-10s %-10s %-10s %-10s\n",
                "ID", "Toán", "Văn", "Anh", "Tổng");

        for (int i = n - 1; i >= 0; i--) {
            System.out.printf("%-5d %-10d %-10d %-10d %-10d\n",
                    hs[i].id,
                    hs[i].toan,
                    hs[i].van,
                    hs[i].anh,
                    hs[i].tinhTongDiem());
        }

        // Top 5
        System.out.println("\n==============================================");
        System.out.println("5 thí sinh có tổng điểm cao nhất");
        System.out.println("==============================================");

        System.out.printf("%-5s %-10s %-10s %-10s %-10s\n",
                "ID", "Toán", "Văn", "Anh", "Tổng");

        for (int i = n - 1; i >= Math.max(0, n - 5); i--) {
            System.out.printf("%-5d %-10d %-10d %-10d %-10d\n",
                    hs[i].id,
                    hs[i].toan,
                    hs[i].van,
                    hs[i].anh,
                    hs[i].tinhTongDiem());
        }

    }
}