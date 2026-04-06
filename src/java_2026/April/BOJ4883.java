package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ4883 {
    static int[] dx = {1,1,1,0};
    static int[] dy = {-1,0,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while (!(s= br.readLine()).equals("0")){
            int n = Integer.parseInt(s);
            int[][] graph = new int[n][3];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[n][3];
            dp[0][1] = graph[0][1];
            dp[0][2] = graph[0][1]+graph[0][2];
            for (int i = 1; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            int sx =0;
            int sy = 1;
            while (sx < n) {
                for (int k = 0; k < 4; k++) {
                    int nx = sx + dx[k];
                    int ny = sy + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < 3) {
                        dp[nx][ny] = Math.min(dp[nx][ny], dp[sx][sy] + graph[nx][ny]);
                    }
                }
                if (sy<2) sy++;
                else {
                    sy = 0;
                    sx++;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            sb.append(tc).append(". ").append(dp[n-1][1]).append("\n");
            tc++;
        }
        System.out.println(sb);
    }
}
