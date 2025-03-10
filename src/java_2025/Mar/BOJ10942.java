package java_2025.Mar;
import java.io.*;
import java.util.*;
public class BOJ10942 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int n = Integer.parseInt(br.readLine());
         int[] arr = new int[n];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }

         boolean[][] dp = new boolean[n][n];
         // 모든 한 칸짜리 구간은 팰린드롬
         for (int i = 0; i < n; i++) {
             dp[i][i] = true;
         }

         // 두 원소 구간 초기화
         for (int i = 0; i < n-1; i++) {
             if (arr[i] == arr[i+1])
                dp[i][i+1] = true;
         }

         // 세 원소 구간 이상
         for (int l = 3; l <= n; l++) {
             for (int i = 0; i <= n - l; i++) {
                 int j = i + l - 1;
                 if (arr[i] == arr[j] && dp[i+1][j-1])
                     dp[i][j] = true;
             }
         }

         int m = Integer.parseInt(br.readLine());
         for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
             int s = Integer.parseInt(st.nextToken());
             int e = Integer.parseInt(st.nextToken());
             bw.write(dp[s-1][e-1] ? "1" : "0");
             bw.newLine();
         }
         bw.flush();
    }
}
