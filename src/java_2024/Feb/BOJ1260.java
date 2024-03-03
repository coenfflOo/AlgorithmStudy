package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ1260 {
    static int l;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        l = graph.length;

        visited = new boolean[l];
        dfs(v);
        System.out.println();

        visited = new boolean[l];
        bfs(v);
    }

    static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");

        for (int i = 0; i < l; i++) {
            if(!visited[i] && graph[v][i] == 1){
                dfs(i);
            }
        }
    }



    static void bfs(int v){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()){
            int n = queue.poll();
            System.out.print(n+" ");

            for (int i = 0; i < l; i++) {
                if (!visited[i]&&graph[n][i]==1){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}