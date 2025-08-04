package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;

import static java.lang.System.exit;

public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost [i] = Integer.parseInt(br.readLine());
        }
        if (k == 0) {
            System.out.println("1");
            exit(0);
        }
        Arrays.sort(cost);
        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = cost[i];
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);
    }
}
