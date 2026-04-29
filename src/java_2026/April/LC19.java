package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;

public class LC19 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
    }

    public static int longestConsecutive(int[] nums) {
        // 1. 모든 숫자를 Set에 넣어서 "존재 여부"를 O(1)에 확인
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        // 2. 각 숫자에 대해 탐색
        for (int num : set) {

            // 🔥 핵심 조건
            // num-1이 없으면 → 이 숫자는 "연속 수열의 시작점"
            // (중간 숫자에서 시작하면 중복 탐색 발생 → O(n^2) 됨)
            if (!set.contains(num - 1)) {

                int curr = num;   // 현재 값
                int length = 1;   // 수열 길이 (자기 자신 포함)

                // 3. num부터 시작해서 num+1, num+2... 계속 확장
                while (set.contains(curr + 1)) {
                    curr++;      // 다음 숫자로 이동
                    length++;    // 길이 증가
                }

                // 4. 최대 길이 갱신
                max = Math.max(max, length);
            }
        }

        return max;
    }
}
