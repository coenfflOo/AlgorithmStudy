package java_2023.October;
import java.io.*;
import java.util.*;

public class bj1149 {
    static int[] R;
    static int[] G;
    static int[] B;
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        R = new int[N];
        G = new int[N];
        B = new int[N];
        dp = new int[N][3];
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            cost[i][0] = R[i];
            cost[i][1] = G[i];
            cost[i][2] = B[i];
        }

        dp[0][0] = R[0];
        dp[0][1] = G[0];
        dp[0][2] = B[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int minCost = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        bw.write(String.valueOf(minCost));
        bw.flush();
    }
}
// 빨강, 초록, 파랑으로 칠하는 비용을 각각 저장하는 배열을 생성합니다.
// 예를 들어, r[i], g[i], b[i]는 i번째 집을 빨강, 초록, 파랑으로 칠하는 비용을 나타내는 배열입니다.
//
//다이나믹 프로그래밍을 위한 배열을 초기화합니다. 여기서 dp[i][j]는 i번째 집까지 칠하고, i번째 집의 색이
// j(0: 빨강, 1: 초록, 2: 파랑)일 때의 최소 비용을 나타내는 배열입니다.
//
//첫 번째 집을 칠할 때는 어떤 색을 선택해도 무방하므로, dp[1][0], dp[1][1], dp[1][2]를 각각 r[1], g[1], b[1]로 초기화합니다.
//
//두 번째 집부터 N번 집까지 각각의 경우에 대해 다음과 같은 점화식을 사용하여 dp 배열을 갱신합니다:
//
//dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2])
//dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2])
//dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1])
//
//마지막 집(N번 집)까지의 최소 비용은 dp[N][0], dp[N][1], dp[N][2] 중에서 가장 작은 값이 됩니다.