package java_2026.Mar;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[k+1][n+1];
            for (int i = 1; i < n + 1; i++) {
                dp[0][i] = i;
            } // a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합
            for (int i = 1; i <= k; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j==0) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
