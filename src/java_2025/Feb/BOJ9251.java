package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        int n = str1.length;
        int m = str2.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (str1[i-1].equals(str2[j-1])){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
