package java_2026.April;

import java.util.Arrays;

public class LC13 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] counts = new int[n + 1]; // 0 ~ n까지 각 숫자의 1의 개수를 저장할 배열

        for (int i = 1; i <= n; i++) {

            // i가 짝수인 경우 (마지막 비트가 0)
            if (i % 2 == 0) {
                // i >> 1 은 i를 2로 나눈 값 (오른쪽으로 한 칸 shift)
                // 짝수는 마지막 비트가 0이므로 1의 개수는 i/2와 동일
                counts[i] = counts[i >> 1];

            } else {
                // i가 홀수인 경우 (마지막 비트가 1)
                // (i & 1) = 1 → 마지막 비트가 1이라는 의미
                // 따라서 i의 1 개수 = (i/2의 1 개수) + 1
                counts[i] = (i & 1) + counts[i >> 1];
            }
        }

        return counts;
    }
}
