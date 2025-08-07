package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1707 {
    static List<Integer>[] graph;
    static int[] color;
    static boolean isBipartite;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            color = new int[v + 1];
            isBipartite = true;

            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    color[i] = 1;
                    queue.add(i);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        for (int num : graph[cur]) {
                            if (color[num] == 0) {
                                color[num] = 3 - color[cur];
                                queue.add(num);
                            } else if (color[num] == color[cur]) {
                                isBipartite = false;
                                break;
                            }
                        }
                    }
                }
            }
            sb.append(isBipartite?"YES":"NO").append("\n");
        }
        System.out.println(sb);
    }
}
/**
 * 이분 그래프인 경우
 *
 * 정점: 1, 2, 3, 4
 * 간선: (1-2), (2-3), (3-4)
 *
 * 이걸 그래프로 그려보면:
 * 1 - 2 - 3 - 4
 *
 * 이걸 다음처럼 색칠하거나 그룹으로 나눌 수 있음:
 * 집합 A: 1, 3
 * 집합 B: 2, 4
 *
 * 이렇게 되면:
 * 1과 2는 연결됐는데 → 서로 다른 집합
 * 2와 3은 연결됐는데 → 서로 다른 집합
 * 3과 4는 연결됐는데 → 서로 다른 집합
 *
 * 💡 한 집합 안에 연결된 정점은 없음!
 * ✅ 이것이 이분 그래프
 * **/