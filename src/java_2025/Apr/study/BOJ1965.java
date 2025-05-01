package java_2025.Apr.study;
import java.util.*;
import java.io.*;
public class BOJ1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] box = new int[n+1];
        int[] dp = new int[n+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n+1; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (box[j]<box[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(dp[j],max);
            }
        }
        System.out.println(max);
    }
}
