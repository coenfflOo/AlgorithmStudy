package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC09 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{0,1,1}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int cal = nums[i] + nums[left] + nums[right];
                if (cal == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if (cal < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
