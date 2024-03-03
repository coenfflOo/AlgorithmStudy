package java_2024.Feb;
import java.util.*;
import java.io.*;
public class BOJ2606 {
    static int n, cnt;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];

        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        visited = new boolean[graph.length];
        cnt = -1;
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int v){
        visited[v] = true;
        cnt++;

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]&&graph[v][i]==1){
                dfs(i);
            }
        }
    }
}
