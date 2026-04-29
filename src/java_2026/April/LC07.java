package java_2026.April;
public class LC07 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left+right)/2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
