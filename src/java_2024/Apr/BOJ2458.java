package java_2024.Apr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2458 {
    static int n;
    static int[][] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        people = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people[a][b] = 1;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isConnected(i))
                cnt++;
        }

        System.out.println(cnt);
    }

    static boolean isConnected(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        int cnt = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (people[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        if (cnt == n)
            return true;

        visited = new boolean[n + 1];
        queue.clear();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (people[i][cur] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }

        return cnt == n;
    }
}
