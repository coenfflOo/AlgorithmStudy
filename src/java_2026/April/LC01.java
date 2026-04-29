package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC01 {
    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int index1 = 0, index2 = 0;
//        while (left < right) {
//            int sum = nums[left] + nums[right];
//            if (sum == target) {
//                index1 = left;
//                index2 = right;
//                break;
//            } else {
//                right--;
//                if(left == right){
//                    left++;
//                    right = nums.length - 1;
//                }
//            }
//        }
//        return new int[]{index1,index2};
        int[] result = new int[2];
        Map<Integer,Integer> HM = new HashMap<>(); // 숫자 값, 인덱스
        int sub_r=0;
        for(int i=0; i<nums.length; i++){
            sub_r = target - nums[i]; // nums[i]와 더해서 target이 되려면 필요한 값
            if(HM.containsKey(sub_r)){
                result[0] = HM.get(sub_r);
                result[1] = i;
                break;
            }
            HM.put(nums[i], i);
        }
        return result;
    }
}
