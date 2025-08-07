package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ17953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] feelings = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                feelings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = feelings[i][0];
        }
        for (int day = 1; day < n; day++) {
            for (int cur = 0; cur < m; cur++) {
                for (int prev = 0; prev < m; prev++) {
                    int add = (cur == prev) ? feelings[cur][day]/2 : feelings[cur][day];
                    dp[day][cur] = Math.max(dp[day][cur], dp[day-1][prev] + add);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        System.out.println(ans);
    }
}
