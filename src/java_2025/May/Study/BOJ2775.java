package java_2025.May.Study;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[][] dp = new int[16][16];
        for (int i = 0; i < 16; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 16; j++) {
                dp[i][j] = dp[i][j-1]+dp[i - 1][j];
            }
        }
        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
