package java_2024.Feb;
import java.util.*;
import java.io.*;
public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] RGB = new int[n][3];
        int[][] dp = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            RGB[i][0] = Integer.parseInt(st.nextToken());
            RGB[i][1] = Integer.parseInt(st.nextToken());
            RGB[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = RGB[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = RGB[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = RGB[i][2]+Math.min(dp[i-1][0],dp[i-1][1]);
        }

        int min = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
        System.out.println(min);
    }
}
