package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cost = new int[n];
            for (int j = 0; j < n; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cost);
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            dp[0] = 1;
            for(int coin : cost) {
                for(int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}

/**
 *
 *[목적: 총 "경우의 수"를 세는 문제]
 * for (int coin : cost) {
 *     for (int j = coin; j <= m; j++) {
 *         dp[j] += dp[j - coin];
 *     }
 *  }
 * -> "몇 가지 방법으로 m원을 만들 수 있나?"
 *
 * [목적: "최소 동전 개수"를 구하는 문제]
 *  for (int coin : cost) {
 *     for (int i = coin; i <= k; i++) {
 *         dp[i] = Math.min(dp[i], dp[i - coin] + 1);
 *     }
 *  }
 *  -> "k원을 만들기 위해 동전을 최소 몇 개 써야 하나?"
 *
 * [목적: "최대 동전 개수"를 구하는 문제]
 *  for (int coin : cost) {
 *     for (int j = coin; j <= m; j++) {
 *         dp[j] = Math.max(dp[j], dp[j - coin] + 1);
 *     }
 *  }
 *  -> "m원을 만들기 위해 동전을 최대한 많이 쓰는 방법은?"
 * **/