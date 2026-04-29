package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC28 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA",1));
        System.out.println(characterReplacement("ABAA",0));
    }

    public static int characterReplacement(String s, int k) {
        int l = 0;
        int maxLeng = 0;
        int maxFreq = 0;

        // HashMap 대신 크기 26짜리 배열로 알파벳 카운트!
        // 'A'-'A'=0, 'B'-'A'=1 ... 'Z'-'A'=25
        int hash[] = new int[26];

        for(int r = 0; r < s.length(); r++) {
            // right 문자 카운트 증가
            hash[s.charAt(r)-'A']++;

            // 현재 윈도우에서 가장 많이 등장하는 문자 수 갱신
            maxFreq = Math.max(hash[s.charAt(r)-'A'], maxFreq);

            // 윈도우 길이 - 최다빈도 문자 수 > k 면
            // 즉 k번으로 다 바꾸기 불가능하면 → left 당기기
            while((r-l+1) - maxFreq > k) {
                hash[s.charAt(l)-'A']--; // left 문자 카운트 줄이기
                l++;
            }

            // 유효한 윈도우 중 최대 길이 갱신
            maxLeng = Math.max(maxLeng, (r-l+1));
        }
        return maxLeng;
    }

//    public static int characterReplacement(String s, int k) {
//        int left = 0;
//        int right = 1;
//        Map<Character, Integer> map = new HashMap<>();
//        int frequent = 1;
//        int max = 1;
//        map.put(s.charAt(left),1);
//        while (right<s.length()){
//            char c = s.charAt(right);
//            map.put(c, map.getOrDefault(c,0)+1);
//            frequent = Math.max(frequent, map.get(c));
//            if ((right-left+1)-frequent > k){
//                map.put(s.charAt(left), map.get(s.charAt(left))-1);
//                left++;
//            }
//            max = Math.max(max, right-left+1);
//            right++;
//        }
//        return max;
//    }
}
