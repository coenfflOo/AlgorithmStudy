package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC04 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i];
        }
        for (int i = nums.length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i];
        }
        int[] answer = new int[nums.length];
        answer[0] = right[1];
        answer[nums.length-1] = left[nums.length-2];
        for (int i = 1; i < nums.length-1; i++) {
            answer[i] = left[i-1] * right[i+1];
        }
        return answer;
    }
}