package October;
import java.util.*;
import java.io.*;
public class bj11726 {
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
            return 2;

        if (dp[N] != 0)
            return dp[N];

        dp[N] = (Tiling(N - 2) + Tiling(N - 1))%10007;
        return dp[N];
    }
}
// 1 1
// 2 2
// 3 3
// 4 5
// 5 8
// 6 13
// 7 21
// 8 34
// 9 55