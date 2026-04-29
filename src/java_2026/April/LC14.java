package java_2026.April;

public class LC14 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {

        // 결과를 nums.length (즉, n)으로 시작
        // 이유: 우리는 0 ~ n까지의 모든 값을 XOR해야 하는데,
        // 반복문에서는 0 ~ n-1까지만 다루므로 n을 미리 포함시킴
        int ans = nums.length;

        for(int i = 0; i < nums.length; i++){

            // i는 "원래 있어야 할 값 (0 ~ n-1)"
            // → 전체 집합을 만들기 위한 XOR
            ans ^= i;

            // nums[i]는 "실제로 배열에 있는 값"
            // → 실제 값들을 XOR
            ans ^= nums[i];
        }

        // XOR 성질:
        // a ^ a = 0 → 같은 값은 사라짐
        // 0 ^ a = a → 남은 값 유지
        //
        // 결국:
        // (0 ^ 1 ^ 2 ^ ... ^ n) ^ (nums의 모든 값)
        // → 있는 값들은 전부 상쇄되고
        // → 빠진 값 하나만 남음

        return ans;
    }
}