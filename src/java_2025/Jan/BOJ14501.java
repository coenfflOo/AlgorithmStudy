package java_2025.Jan;
import static java.lang.System.exit;

import java.util.*;
import java.io.*;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i번째 날까지 고려했을 때의 최대 수익
        int[] dp = new int[n+2]; // N+1까지 인덱스 사용하기 위해 N+2

        for(int i = 1; i <= n; i++){
            // (1) i번째 날 상담을 안 하는 경우
            dp[i+1] = Math.max(dp[i+1], dp[i]);

            // (2) i번째 날 상담을 하는 경우 (일정이 넘어가지 않는지 확인)
            if(i + t[i] - 1 <= n){
                int nextDay = i + t[i];
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + p[i]);
            }
        }

        // N+1일째(즉 N일 까지 전부 고려)에서의 최대 수익이 정답
        System.out.println(dp[n+1]);
    }
}
