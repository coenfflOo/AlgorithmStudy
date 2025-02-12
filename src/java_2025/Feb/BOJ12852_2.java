package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ12852_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        DP[] dp = new DP[n+1];
        dp[0] = new DP(0,-2);
        dp[1] = new DP(0,-1);
        for (int i = 2; i < n+1; i++) {
            dp[i] = new DP(0,0);
        }
        for (int i = 1; i < n; i++) {
            DP cur = dp[i];
            if(dp[i+1].cnt==0)
                dp[i+1] = new DP(cur.cnt+1, i);
            else dp[i+1] = dp[i+1].cnt> cur.cnt+1? new DP(cur.cnt+1, i): dp[i+1];

            if (i*2<=n){
                if(dp[i*2].cnt==0)
                    dp[i*2] = new DP(cur.cnt+1, i);
                else dp[i*2] = dp[i*2].cnt> cur.cnt+1? new DP(cur.cnt+1, i): dp[i*2];
            }

            if (i*3<=n){
                if(dp[i*3].cnt==0)
                    dp[i*3] = new DP(cur.cnt+1, i);
                else dp[i*3] = dp[i*3].cnt> cur.cnt+1? new DP(cur.cnt+1, i): dp[i*3];
            }
        }

        System.out.println(dp[n].cnt);
        int idx = n;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        while (dp[idx].prev > -1){
            sb.append(dp[idx].prev).append(" ");
            idx = dp[idx].prev;
        }
        System.out.println(sb);
    }

    private static class DP {
        int cnt;
        int prev;

        public DP(int cnt, int prev){
            this.cnt = cnt;
            this.prev = prev;
        }
    }
}
