package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = (N-i)*2 ; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = N-1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = (N-i)*2 ; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
