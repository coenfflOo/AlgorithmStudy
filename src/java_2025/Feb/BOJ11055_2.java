package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ11055_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for(int j=i; j>=0; j--){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }

        int max = 0;
        for(int num: dp){
            max = Math.max(max, num);
        }
        System.out.println(max);
    }
}
