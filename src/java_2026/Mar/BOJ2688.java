package java_2026.Mar;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ2688 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int T = Integer.parseInt(st.nextToken());
//        BigInteger[][] dp = new BigInteger[65][10];
//        for (int j = 0; j < 10; j++) {
//            dp[1][j] = BigInteger.ONE;
//            dp[2][j] = BigInteger.valueOf(10-j);
//        }
//        for (int i = 3; i < 65; i++) {
//            for (int j = 0; j < 10; j++) {
//                dp[i][j] = BigInteger.ZERO;
//                for (int k = j; k <= 9; k++) {
//                    dp[i][j] = dp[i][j].add(dp[i-1][k]);
//                }
//            }
//        }
//        while (T-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int n = Integer.parseInt(st.nextToken());
//            BigInteger sum = BigInteger.ZERO;
//            for (int j = 0; j < 10; j++) {
//                sum = sum.add(dp[n][j]);
//            }
//            System.out.println(sum);
//        }
//    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[][] dp = new long[N + 1][10];
            Arrays.fill(dp[1], 1);

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (j == 0) {
                        dp[i][0] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i <= 9; i++) {
                sum += dp[N][i];
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
