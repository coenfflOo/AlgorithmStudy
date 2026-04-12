package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int prev = 0;
            for (int j = 0; j < num; j++) {
                int next = Integer.parseInt(st.nextToken());
                if (prev != 0){
                    indegree[next]++;
                    list.get(prev).add(next);
                }
                prev = next;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        int[] ans = new int[N];
        while (!queue.isEmpty()){
            int cur = queue.poll();
            ans[index++] = cur;
            for (int next : list.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        if (index != N){
            System.out.println("0");
        } else {
            for (int i = 0; i < N; i++) {
                System.out.println(ans[i]);
            }
        }
    }
}
