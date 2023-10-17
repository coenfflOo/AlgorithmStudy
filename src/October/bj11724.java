package October;
import java.util.*;
import java.io.*;
public class bj11724 {
    static int[][] graph;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i); // 모든 정점을 시작점으로 DFS 탐색
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void dfs(int V) {
        visited[V] = true;

        for (int i = 1; i < graph.length; i++) {
            if (graph[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
