package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 횟수 따로 출력
        hanoi(1,3,n);
    }

    private static void hanoi (int a, int b, int n) {
        if (n==0)
            return;
        hanoi(a,6-a-b, n-1);
        System.out.println(a+" "+b);
        hanoi(6-a-b, b, n-1);
    }
}
