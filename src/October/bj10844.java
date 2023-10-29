package October;
import java.util.*;
import java.io.*;
public class bj10844 {
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        // 길이가 1인 계단 수 초기화
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 길이가 2 이상인 계단 수 개수 계산
        for (int length = 2; length <= N; length++) {
            for (int digit = 0; digit < 10; digit++) {
                if (digit == 0) {
                    dp[length][0] = dp[length - 1][1];
                } else if (digit == 9) {
                    dp[length][9] = dp[length - 1][8];
                } else {
                    dp[length][digit] = (dp[length - 1][digit - 1] + dp[length - 1][digit + 1]) % MOD;
                }
            }
        }

        // 길이가 N인 계단 수 개수 합산
        long total = 0;
        for (int i = 0; i < 10; i++) {
            total = (total + dp[N][i]) % MOD;
        }

        bw.write(String.valueOf(total));
        bw.flush();
    }
}