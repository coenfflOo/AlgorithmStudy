package October;

import java.util.*;
import java.io.*;

public class bj1904 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        bw.write(String.valueOf(rangeTile(N)));
        bw.flush();
    }

    private static int rangeTile(int n) {
        if (n <= 3) {
            dp[n] = n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = (rangeTile(n - 1) + rangeTile(n - 2)) % 15746;
        return dp[n];
    }
}