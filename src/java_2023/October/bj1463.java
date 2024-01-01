package java_2023.October;

import java.io.*;

public class bj1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1]; // dp[i]는 i를 1로 만드는데 필요한 최소 연산 횟수를 저장

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 현재 수에서 1을 뺀 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 현재 수를 2로 나눈 경우
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 현재 수를 3으로 나눈 경우
        }

        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
}
