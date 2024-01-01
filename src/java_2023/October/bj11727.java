package java_2023.October;
import java.io.*;
public class bj11727 {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        bw.write(String.valueOf(Tiling(N)));
        bw.flush();
    }

    private static long Tiling(int N) {
        if (N == 0)
            return 0;
        else if (N == 1)
            return 1;
        else if (N == 2)
            return 3;

        if (dp[N] != 0)
            return dp[N];

        dp[N] = (Tiling(N - 2)*2 + Tiling(N - 1))%10007;
        return dp[N];
    }
}
// 1 1
// 2 3
// 3 5
// 4 11
// 5 21
// 6 43
// 7 85
// 8 171
// 9 341
// 10 683
// 11 1365
// 12 2731