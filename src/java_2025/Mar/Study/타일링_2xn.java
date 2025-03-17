package java_2025.Mar.Study;

public class 타일링_2xn {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<n+1; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1_000_000_007;
        }
        return dp[n];
    }
}
