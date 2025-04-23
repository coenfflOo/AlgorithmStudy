package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][21];
        dp[0][numbers[0]] = 1;
        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i-1][j] != 0) {
                    if (j+numbers[i] > -1 && j+numbers[i] < 21) dp[i][j+numbers[i]]+=dp[i-1][j];
                    if (j-numbers[i] > -1 && j-numbers[i] < 21) dp[i][j-numbers[i]]+=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-2][numbers[n-1]]);
    }
}
