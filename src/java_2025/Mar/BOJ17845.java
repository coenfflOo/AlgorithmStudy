package java_2025.Mar;
import java.util.*;
import java.io.*;

import static java.lang.System.exit;

public class BOJ17845 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Study[] study = new Study[k+1];
        for (int i=1; i<k+1; i++) {
            st = new StringTokenizer(br.readLine());
            int im = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            study[i] = new Study(im,t);
        }

        int[][] dp = new int[k+1][n+1];
        for (int i=1; i<k+1; i++) {
            for (int j=0; j<n+1; j++) {
                dp[i][j] = j-study[i].time >= 0 ? Math.max(dp[i-1][j], dp[i-1][j-study[i].time]+study[i].important) : dp[i-1][j];
            }
        }
        System.out.println(dp[k][n]);
        exit(0);
    }

    static class Study{
        int important;
        int time;
        public Study(int i, int t){
            this.important = i;
            this.time = t;
        }
    }
}
