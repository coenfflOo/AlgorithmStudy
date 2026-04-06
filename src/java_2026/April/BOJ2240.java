package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] tree = new int[t+1];
        for (int i = 1; i <= t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[t+1][w+1];

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                int cur = (j % 2 == 0) ? 1 : 2;
                int yummy = (tree[i]==cur) ? 1 : 0;

                dp[i][j] = dp[i-1][j] + yummy;
                if (j>0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+yummy);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= w; i++) {
            max = Math.max(max, dp[t][i]);
        }
        System.out.println(max);
    }
}
