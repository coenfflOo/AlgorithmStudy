package java_2026.April;

import java.util.Arrays;

public class LC42 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1,2,3}));
    }
    public static int rob(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp2[0] = 0;
        if (nums.length == 1) return nums[0];
        dp1[1] = Math.max(nums[0], dp1[1]);
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length-1){
                dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i]);
            } else {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
                dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i]);
            }
        }
        return Math.max(dp1[nums.length-2], dp2[nums.length-1]);
    }
}
