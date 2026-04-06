package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] times = new int[n];
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < indegree[i]; j++) {
                int prev = Integer.parseInt(st.nextToken())-1;
                jobs.get(prev).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] finish = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                finish[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : jobs.get(cur)) {
                finish[next] = Math.max(finish[next], finish[cur] + times[next]);
                if(--indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, finish[i]);
        }
        System.out.println(ans);
    }
}
