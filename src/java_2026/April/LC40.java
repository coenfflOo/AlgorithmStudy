package java_2026.April;

import java.util.Arrays;

public class LC40 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3}, 4));
        System.out.println(combinationSum4(new int[]{9}, 3));
    }
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
