package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC05 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-2,1}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = Math.max(sums[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sums[i]);
        }
        return maxSum;
    }
}
