package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ13916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n<2) {
            System.out.println("-1");
            return;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100000);
        dp[2] = 1;
        if(n>4){
            dp[5] = 1;
        }
        for (int i = 3; i <= n; i++) {
            if (dp[i-2] != 100000) {
                dp[i] = Math.min(dp[i], dp[i-2]+1);
            }
            if (i>4&& dp[i-5] != 100000) {
                dp[i] = Math.min(dp[i], dp[i-5]+1);
            }
        }
        System.out.println(dp[n]==100000?-1:dp[n]);
    }
}
