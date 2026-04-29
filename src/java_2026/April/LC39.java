package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC39 {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 빈 문자열은 항상 true

        // 사전에서 가장 긴 단어의 길이 구하기
        // 핵심 최적화! 이것보다 긴 substring은 사전에 있을 수 없음
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            // j를 i-1부터 뒤로 탐색
            // Math.max(i - max_len - 1, 0) 까지만 탐색!
            // max_len보다 긴 substring은 사전에 없으니 볼 필요 없음
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // 찾으면 더 볼 필요 없음
                }
            }
        }
        return dp[n];
    }
}
