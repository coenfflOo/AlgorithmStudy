package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < s; j++) {
                int singer = Integer.parseInt(st.nextToken());
                adj[prev].add(singer);
                indegree[singer]++;
                prev = singer;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            if (indegree[i] == 0)
                queue.add(i);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append("\n");
            cnt++;
            for (int s : adj[cur]) {
                if (--indegree[s] == 0)
                    queue.add(s);
            }
        }

        if (cnt == n) System.out.println(sb);
        else System.out.println(0);
    }
}
