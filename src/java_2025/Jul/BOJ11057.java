package java_2025.Jul;
import java.io.*;
import java.lang.*;
public class BOJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // N개 자리의 숫자 중 가장 맨뒤의 숫자가 K일때의 경우의 수
        int[][] dp = new int[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    // N-1의 K와 같거나 작은 수를 선택해서 모든 경우의 수
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum%10007);
    }
}