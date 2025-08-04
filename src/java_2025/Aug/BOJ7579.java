package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] memory  = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memory [i] = Integer.parseInt(st.nextToken());
        }
        int[] cost  = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost [i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[10001];
        for (int i = 0; i < n; i++) {
            for (int j = 10000; j >= cost[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int j = 0; j <= 10000; j++) {
            if (dp[j] >= m) {
                System.out.println(j);
                break;
            }
        }
    }
}
