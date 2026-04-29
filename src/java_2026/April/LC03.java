package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC03 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean containsDuplicate(int[] nums) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(nums[0],0);
//        for (int i = 1; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                return true;
//            } else map.put(nums[i],0);
//        }
//        return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
