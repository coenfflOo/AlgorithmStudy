package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost [i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cost);
        int[] dp = new int[k+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int coin : cost) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}
