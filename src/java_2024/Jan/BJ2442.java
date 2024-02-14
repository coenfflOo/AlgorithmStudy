package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = N-i; j >0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
