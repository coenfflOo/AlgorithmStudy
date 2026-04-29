package java_2026.April;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC35 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        return getSubCount(s.toCharArray(), 0, 0);
    }

    public static int getSubCount(char[] arr, int pos, int count) {
        int length = arr.length;

        // pos가 끝을 넘어가면 재귀 종료
        if(pos > length - 1) {
            return count;
        }

        int left = pos, right = pos;

        // 현재 pos에서 같은 문자가 연속되는 구간 찾기
        // ex) "aaa"에서 pos=0이면 right가 2까지 이동
        while(right < length - 1 && arr[right] == arr[right + 1] && ++right >= 0);

        // 다음 재귀는 연속 구간 끝+1부터 시작
        pos = right;

        // 연속된 같은 문자 개수
        // ex) "aaa" → tCount=3
        int tCount = right - left + 1;

        // 연속된 같은 문자로 만들 수 있는 팰린드롬 수
        // ex) "aaa" → "a"x3 + "aa"x2 + "aaa"x1 = 6
        // 공식: n*(n+1)/2
        count += (tCount * (tCount + 1)) / 2;

        // 연속 구간 바깥으로 양쪽 확장하면서 팰린드롬 추가 카운트
        // ex) "baab" → "aa" 처리 후 바깥 b,b 비교
        while(left > 0 && right < length - 1 && arr[--left] == arr[++right] && ++count >= 0);

        // 다음 pos부터 재귀
        return getSubCount(arr, pos + 1, count);
    }

//    public static int countSubstrings(String s) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            list.add(s.charAt(i) + "");
//            int left = i - 1, right = i + 1;
//            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                list.add(s.substring(left, right+1));
//                left--;
//                right++;
//            }
//
//            if (i<s.length()-1&&s.charAt(i)==s.charAt(i+1)) {
//                list.add(s.substring(i, i+2));
//                left = i - 1;
//                right = i + 2;
//                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                    list.add(s.substring(left, right + 1));
//                    left--;
//                    right++;
//                }
//            }
//        }
//        return list.size();
//    }
}
