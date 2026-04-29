package java_2026.April;

public class LC43 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("06"));
        System.out.println(numDecodings("0"));
    }

    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        // dp[0] = 빈 문자열 기저 조건
        // 첫 글자가 '0'이면 디코딩 불가 → 0
        // 아니면 1
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i <= len; i++) {

            // 1자리로 읽기
            // s.charAt(i-1) = 현재 보고있는 글자
            // '0'이 아니면 앞의 dp[i-1]가지에 현재 글자 붙이기
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // i=1일때는 두자리 체크 불가 → 스킵
            if (i < 2) continue;

            // 2자리로 읽기
            // 현재와 이전 글자를 합쳐서 10~26 사이면
            // 앞의 dp[i-2]가지에 두자리 숫자 붙이기
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
