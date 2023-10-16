package October;

import java.util.*;
import java.io.*;

public class bj1260 {
    static int[][] graph;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 시작할 정점의 번호


        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            graph[a][b] = 1; // 정점 a와 정점 b가 연결되어 있다.
            graph[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        bw.newLine();

        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int V) throws IOException {
        visited[V] = true;
        bw.write(V + " ");

        if (V == graph.length) {
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            if (graph[V][i] == 1 && !visited[i]) {
                // 현재 정점 V와 연결된 정점 i 중에서 아직 방문하지 않은 정점
                dfs(i);
            }
        }
        bw.flush();
    }

    private static void bfs(int V) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(V);
        visited[V] = true;
        bw.write(V + " ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            // 현재 정점 tmp와 연결된 아직 방문하지 않은 정점을 큐에 추가하고 방문
            for (int i = 1; i < graph.length; i++) {
                if (graph[tmp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    bw.write(i+" ");
                }
            }
        }
        bw.flush();
    }
}
