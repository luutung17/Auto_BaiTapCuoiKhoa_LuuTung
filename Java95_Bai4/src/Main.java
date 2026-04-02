import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Mảng
        //1.Khai báo và khởi tạo
        int[] ar0;
        ar0 = new int[10];
        //length: chiều dài của mảng, và cố định
        String[] ar1 = new String[10];
        int[] ar2 = {1, 345, 721, 4, 7, 3, 6, 3, 4, 1};
        System.out.println(Arrays.toString(ar0));
        System.out.println(Arrays.toString(ar1));
        Scanner input = new Scanner(System.in);
//        for (int i=0;i<ar0.length;i++){
//            System.out.println("Nhập aro["+i+"]: ");
//            ar0[i]= input.nextInt();
//        }
        // Sắp xếp
        //Arrays.sort(ar1);// nhỏ -> lớn (asc)
        //System.out.println(Arrays.toString(ar1));
        Arrays.sort(ar2, 5, 9); //lấy từ thằng 5 đến thằng 8 không lấy thằng 9
        System.out.println(Arrays.toString(ar2));
        //
        // Mảng hai chiều
        int[][] matrix = new int[3][4];//3 hàng và 4 cột
        matrix[0][0] = 1;// phần ở hàng 0, cột 0
        matrix[0][1] = 2;
        matrix[2][3] = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        //II Chuỗi String
        String name = "Dat";
        //String là kiểu obj
        String hello = "Xin chao";
        hello = hello + name; // nối chuỗi
        hello = hello.concat(name);// cũng là nối chuỗi
        System.out.println(hello);
        //Tạo chuỗi ngẫu nhiên
        //Một số hàm thường dùng
        // + cắt chuỗi
        String s1 = "Hello Java";
        String s2 = s1.substring(0, 5);
        //+ cắt tại ca vị trí xác định theo mẫu tìm kiếm
        s1 = "Cộng xã hòa xã hội chủ nghĩa Việt Nam";
        int i0 = s1.indexOf("xã");
        int i1 = s1.indexOf("xã", i0 + 1);
        int i2 = s1.indexOf("Việt");
        s2 = s1.substring(i1, i2);
        System.out.println(s2);
        //+ ktra rỗng
        s1.isEmpty();//trả về định dạng true false
        //tra xem chuỗi có chứa một chuỗi con nào đó hay không
        s1.contains("Việt Nam"); //true
        //So khớp nội dung
        s1 = "abcABC";
        s2 = "abcABC";
        System.out.println(s1.equals(s2));
        s1 = "s001;Lưu Tùng;123";
        String[] fields = s1.split(";");

        //Long text-> list words (tách thành từng chữ)
//        String longText= "anh tunfdgjsf; sdfjkdfj gkldlfhk gdfl ;gkhdfgl;h dfgl; hdf;lgkh d;flgk hdflk;g dlk;gh  dl;fgkhdflk ;ghd;f lghdl ;fghdl;g hdl f;g;d fgh";
//        String[] words=longText.split("[;,\\.\s]+");
//        for (int i =0; i<longText.length();i++){
//            System.out.println(words[i]);
//        }
        //Tìm kiếm và thay thế
        s1 = "Cộng xã hòa xã hội chủ nghĩa Việt Nam";
        s2= s1.replace(" ","-");
        System.out.println(s2);
        char[] core= s1.toCharArray(); // chuyển chuỗi thành mảng kí tự

    }

//    public static String randomString(int length) {
//        String seed = "acgfaeriohjoihkljiophAJDFJNSJ123456789";
//        Random random = new Random();
//        char[] chars=new char[length];
//
//        for (int i = 0; i < length; i++) {
//            int number = random.nextInt(seed.length());
//            char[i] = seed.charAt(number);
//        }
//        return new String(chars);
//    }

}
