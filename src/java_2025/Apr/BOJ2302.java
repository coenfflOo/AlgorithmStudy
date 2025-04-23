package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] vip = new int[m+2];
        for (int i = 1; i <= m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        vip[m+1] = n+1;

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        long ans = 1;
        for (int i = 1; i < m+2; i++) {
            ans *= dp[vip[i]-vip[i-1]-1];
        }
        System.out.println(ans);
    }
}
