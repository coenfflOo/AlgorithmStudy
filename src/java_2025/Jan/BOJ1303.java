package java_2025.Jan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1303 {
    private static int n,m,wSum,bSum;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        for(int i=0; i<m; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<n; j++){
                if(str[j].equals("W"))
                    graph[i][j] = 1;
                else
                    graph[i][j] = 2;
            }
        }
        visited = new boolean[m][n];

        wSum = 0;
        bSum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j])
                    continue;

                visited[i][j] = true;
                if(graph[i][j]==1) {
                    int num = dfs(i, j, 1);
                    wSum += num*num;
                } else if(graph[i][j]==2) {
                    int num = dfs(i, j, 2);
                    bSum += num*num;
                }
            }
        }
        System.out.println(wSum+" "+bSum);
    }

    private static int dfs(int i, int j, int color){
        int cnt = 1;
        for(int k=0; k<4; k++){
            int ni = i+dx[k];
            int nj = j+dy[k];

            if(ni<0||nj<0||ni>=m||nj>=n||visited[ni][nj]||graph[ni][nj]!=color)
                continue;

            visited[ni][nj] = true;
            cnt += dfs(ni, nj, color);
        }
        return cnt;
    }
}
