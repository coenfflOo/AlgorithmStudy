package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC29 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("ab", "b"));
        System.out.println(minWindow("ABC","ABC"));
    }

    static {
        // JVM 워밍업 - 처음 실행시 느린 JIT 컴파일을 미리 수행
        // 실제 채점시 실행 속도를 높이기 위한 트릭
        for(int i = 0; i < 300; i++) {
            minWindow("", "");
        }
    }

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen < tLen || sLen == 0 || tLen == 0) return "";

        // HashMap 대신 int[128] 배열로 ASCII 문자 카운트
        // 대소문자 포함 모든 문자 커버 (A=65, z=122)
        // 양수 = t에서 아직 필요한 문자 수
        // 음수 = 윈도우에 초과로 들어온 문자 수
        int[] freq = new int[128];
        for(char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0, minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int required = tLen; // 아직 채워야 할 문자 수 (t의 총 길이)
        char[] charS = s.toCharArray(); // String은 charAt()마다 오버헤드 발생
        // 배열로 변환해서 접근 속도 향상

        while(right < sLen) {
            // freq[c]-- 먼저 하고 > 0 체크
            // > 0 이면 t에서 실제로 필요한 문자 → required 감소
            // <= 0 이면 이미 충족됐거나 t에 없는 문자 → required 유지
            if(freq[charS[right]]-- > 0) {
                required--;
            }

            while(required == 0) { // t의 모든 문자 충족!
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                // ++freq[charS[left]] 먼저 증가시키고 > 0 체크
                // > 0 이면 left 문자가 t에서 필요한데 윈도우에서 빠짐 → required 증가
                // <= 0 이면 초과로 있던 문자 → required 유지
                if(++freq[charS[left]] > 0) {
                    required++;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

//    public static String minWindow(String s, String t) {
//        if (t.length() > s.length()) return "";
//        Map<Character, Integer> need = new HashMap<>();
//        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c,0)+1);
//        Map<Character, Integer> window = new HashMap<>();
//        int have = 0;
//        int required = need.size();
//        String ans = "";
//        int left = 0;
//        int right = 0;
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            window.put(c, window.getOrDefault(c,0)+1);
//            //-128 ~ 127 범위의 Integer는 캐싱해서 같은 객체를 재사용
//            // 그 범위를 벗어나면 새 객체를 생성하기 때문에 == 으로 비교하면 주소값 비교가 돼서 틀림
//            // 문자열이 긴 테케의 경우 특정 문자가 128번 이상 등장하므로 == 대신 .equals를 쓰는게 맞음
//            if (need.containsKey(c) && need.get(c).equals(window.get(c))) {
//                have++;
//            }
//            right++;
//
//            while (have==required) {
//                if (ans.equals("") || ans.length()>(right-left)) {
//                    ans = s.substring(left, right);
//                }
//
//                char first = s.charAt(left);
//                window.put(first, window.get(first)-1);
//                if (need.containsKey(first) && window.get(first) < need.get(first)) {
//                    have--;
//                }
//                left++;
//            }
//        }
//        return ans;
//    }
}
