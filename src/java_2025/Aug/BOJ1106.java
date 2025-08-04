package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] prices = new int[101];
        Arrays.fill(prices, 101);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            prices[person] = Math.min(prices[person], price);
        }
//        System.out.println(Arrays.toString(prices));
        int[] dp = new int[c+100];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 0; i < 101; i++) {
            int price = prices[i];
            if(price != 101){
                for (int j = i; j < dp.length; j++) {
                    dp[j] = Math.min(dp[j], dp[j - i] + price);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        int result = Integer.MAX_VALUE;
        for (int i = c; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);

    }
}
