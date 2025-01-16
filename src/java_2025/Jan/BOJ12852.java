package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] dp = new int[x + 1]; // 최소 연산 횟수 저장
        int[] prev = new int[x + 1]; // 경로 추적을 위한 배열

        dp[1] = 0; // 1은 연산이 필요 없음
        prev[1] = -1; // 시작점 표시

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1; // 기본적으로 i-1을 통해 도달

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2; // i/2로 도달
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3; // i/3으로 도달
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(dp[x]).append("\n");

        int n = x;
        while (n != -1) {
            sb.append(n).append(" ");
            n = prev[n]; // 이전 숫자로 이동
        }

        System.out.println(sb);
    }
}
