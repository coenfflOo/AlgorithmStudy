package October;
import java.util.*;
import java.io.*;

public class bj2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 직접 연결된 컴퓨터 쌍의 수

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a); // 무방향 그래프이므로 양방향으로 추가
        }

        visited = new boolean[n + 1];
        dfs(1); // 1번 컴퓨터부터 시작

        // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력 (1은 제외)
        System.out.println(count-1);
    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
