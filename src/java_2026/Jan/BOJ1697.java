package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_001];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int q = queue.poll();
                if (q == K) {
                    System.out.println(time);
                    return;
                }
                int qm = q-1;
                int qp = q+1;
                int qd = q*2;
                if (qm>=0&&!visited[qm]){
                    visited[qm] = true;
                    queue.offer(qm);
                }
                if (qp<100_001&&!visited[qp]){
                    visited[qp] = true;
                    queue.offer(qp);
                }
                if (qd<100_001&&!visited[qd]){
                    visited[qd] = true;
                    queue.offer(qd);
                }
            }
            time++;
        }
    }
}
