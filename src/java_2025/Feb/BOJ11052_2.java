package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ11052_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] pay = new int[n+1];
        pay[0] = 0;
        for (int i = 1; i < n+1; i++) {
            pay[i] = price[i];
            for (int j = i-1; j >= i/2; j--) {
                pay[i] = Math.max(pay[i], pay[j]+pay[i-j]);
            }
        }

        System.out.println(pay[n]);
    }
}
