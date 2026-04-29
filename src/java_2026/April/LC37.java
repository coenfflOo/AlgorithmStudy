package java_2026.April;

import java.util.Arrays;

public class LC37 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Integer.MAX_VALUE 대신 amount+1로 초기화
        // 최악의 경우 → 1짜리 동전만 써서 11개
        // amount+1은 절대 초과할 수 없다는 의미
        // Integer.MAX_VALUE + 1 하면 오버플로우 나는데 amount+1은 안전!
        for(int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // 0원은 동전 0개로 만들 수 있음
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                // 현재 금액이 동전보다 크거나 같을 때만 사용 가능
                if(i >= coin) {
                    // coin 하나 쓰고 나머지 dp[i-coin]으로 해결
                    // 모든 동전 시도해서 최솟값 선택
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // dp[amount]가 amount+1 이상이면 만들 수 없는 경우
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

//    public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for(int c: coins){
//            if (c<=amount) dp[c] = 1;
//        }
//        for (int i = 1; i <= amount; i++) {
//            for (int c : coins){
//                if (c <= i && dp[i-c] != Integer.MAX_VALUE) {
//                    dp[i] = Math.min(dp[i], dp[i-c] + 1);
//                }
//            }
//        }
//        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
//    }
}
