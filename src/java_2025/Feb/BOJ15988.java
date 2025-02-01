package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        // 1 2 4 7 13 24 44
        // 1
        // 1+1 | 2
        // 1+1+1 | 2+1 | 1+2 | 3
        // 1+1+1+1 | 2+1+1 | 1+2+1 | 1+1+2 | 2+2 | 3+1 | 1+3
        // 1+1+1+1+1 | 2+1+1+1 | 1+2+1+1 | 1+1+2+1 | 1+1+1+2
        // 1+2+2 | 2+1+2 | 2+2+1 | 1+1+3 | 1+3+1 | 3+1+1 | 2+3 | 3+2
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 1000001; i++) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
