package java_2026.April;

import java.util.HashMap;
import java.util.Map;

public class LC27 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int left = 0;
        int right = 1;
        map.put(s.charAt(0), 0);
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c)+1, left);
            }
            map.put(c, right);
            max = Math.max(max, right - left+1);
            right++;
        }
        return max;
    }
}
