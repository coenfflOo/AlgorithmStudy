package java_2025.Jan;
import static java.lang.System.exit;
import java.io.*;
public class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = wine[1];
        if (n<2){
            System.out.println(dp[n]);
            exit(0);
        }

        dp[2] = dp[1]+wine[2];
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+wine[i-1]+wine[i], dp[i-2]+wine[i]));
        }

        System.out.println(dp[n]);
    }
}
