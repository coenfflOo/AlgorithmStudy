package java_2026.April;

public class LC06 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-1,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur < 0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * cur ,cur);
            min = Math.min(min * cur ,cur);
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
