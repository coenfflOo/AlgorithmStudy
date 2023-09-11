import java.util.Scanner;

public class bj11382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        //큰 수가 나올 수 있음으로 long타입 사용
        sc.close();

        System.out.println(A + B + C);

    }
}