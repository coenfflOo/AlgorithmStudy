package java_2025.Feb;
import java.util.*;
import java.io.*;

public class BOJ2156_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+3];
        int[] dp = new int[n+3];
        for (int i = 3; i < n+3; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 3; i < n+3; i++) {
            dp[i] = Math.max(dp[i-3]+wine[i-1]+wine[i], Math.max(dp[i-2]+wine[i], dp[i-1]));
        }
        System.out.println(dp[n+2]);
    }
}
