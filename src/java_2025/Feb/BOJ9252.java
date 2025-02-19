package java_2025.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        int n = str1.length;
        int m = str2.length;
        DP[][] dp = new DP[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                dp[i][j] = new DP(0);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[i-1].equals(str2[j-1])) {
                    dp[i][j] = new DP(dp[i-1][j-1].len + 1);
                } else {
                    if(dp[i-1][j].len >= dp[i][j-1].len){
                        dp[i][j] = new DP(dp[i-1][j].len);
                    } else {
                        dp[i][j] = new DP(dp[i][j-1].len);
                    }
                }
            }
        }

        System.out.println(dp[n][m].len);
        if (dp[n][m].len != 0){
            StringBuilder sb = new StringBuilder();
            int i = n, j = m;
            while(i > 0 && j > 0) {
                if (str1[i-1].equals(str2[j-1])) { // str1[i−1]와 str2[j−1]가 같다면, 이 문자는 LCS에 포함되는 문자
                    sb.append(str1[i-1]);
                    i--;
                    j--;
                }
                else if (dp[i-1][j].len >= dp[i][j-1].len) {
                    i--;
                } else {
                    j--;
                }
            }
            System.out.println(sb.reverse());
        }
    }

    private static class DP {
        int len;

        public DP(int len){
            this.len = len;
        }
    }
}
