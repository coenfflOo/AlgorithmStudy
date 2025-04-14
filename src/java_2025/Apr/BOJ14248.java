package java_2025.Apr;
import java.util.*;
import java.io.*;
public class BOJ14248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine())-1;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int pi = cur + map[cur];
            int mi = cur - map[cur];

            if (pi>=0&&pi<n&&!visited[pi]){
                queue.add(pi);
                visited[pi] = true;
                cnt++;
            }

            if (mi>=0&&mi<n&&!visited[mi]){
                queue.add(mi);
                visited[mi] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
