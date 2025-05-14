package java_2025.May;
import java.io.*;
import java.lang.*;
public class BOJ15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        int[] arr = {1, 2, 3};
        dp[0] = 1;
        for (int a : arr){
            for (int i = a; i < 10001; i++) {
                dp[i] += dp[i - a];
            }
        }
        for (int i = 0; i < tc; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
