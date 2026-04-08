package java_2026.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] times = new int[N];
            int[] indegree = new int[N];
            for (int i = 0; i < N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken())-1;
                int next = Integer.parseInt(st.nextToken())-1;
                graph.get(prev).add(next);
                indegree[next]++;
            }
            int success = Integer.parseInt(br.readLine())-1;

            Queue<Integer> queue = new ArrayDeque<>();
            int ans = 0;
            int[] finish = new int[N];
            for (int i = 0; i < N; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                    finish[i] = times[i];
                    if (i == success) {
                        ans = finish[i];
                    }
                }
            }

            out: while (!queue.isEmpty()) {
                int cur = queue.poll();
                for(int next : graph.get(cur)) {
                    finish[next] = Math.max(finish[next], finish[cur]+times[next]);
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.add(next);
                        if (next == success) {
                            ans = finish[next];
                            break out;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
