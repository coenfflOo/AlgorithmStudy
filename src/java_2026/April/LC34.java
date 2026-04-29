package java_2026.April;

public class LC34 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    // 팰린드롬은 중심에서 양쪽으로 퍼져나가는 특성 존재
    // 중심이 홀수/짝수 두 가지 경우 모두 체크
    // 홀수: "aba"  → 중심이 1개 (b)
    // 짝수: "abba" → 중심이 2개 (bb)
    public static String longestPalindrome(String s) {
        int num = 1;
        int start = 0;
        int end = 1;
        for (int i = 0; i < s.length(); i++) {
            int[] arr = i>0? expand(s, i-1, i+1) : new int[]{0,1};
            if (num < arr[1]-arr[0]+1) {
                num = arr[1]-arr[0]+1;
                start = arr[0];
                end = arr[1];
            }
            if (i<s.length()-1&&s.charAt(i) == s.charAt(i+1)) {
                arr = expand(s, i-1, i+2);
                if (num < arr[1]-arr[0]+1) {
                    num = arr[1]-arr[0]+1;
                    start = arr[0];
                    end = arr[1];
                }
            }
        }
        return s.substring(start, end);
    }

    public static int[] expand(String s, int left, int right) {
        int l = left, r = right;
        while ((l>=0 && r<s.length()) && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return new int[]{l+1, r};
    }
}
