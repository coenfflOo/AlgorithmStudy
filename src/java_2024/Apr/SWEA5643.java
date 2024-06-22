package java_2024.Apr;

import java.util.*;
import java.io.*;

public class SWEA5643 {
    static int n;
    static int[][] graph;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            int m = sc.nextInt();
            graph = new int[n + 1][n + 1];

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
            }

            int cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                if (connectedAll(i)) {
                    cnt++;
                }
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }

    private static boolean connectedAll(int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int connect = 1;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = 0; i < n + 1; i++) {
                if (graph[num][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    connect++;
                }
            }
        }

        if (connect == n) {
            return true;
        }

        visited = new boolean[n + 1];
        queue.clear();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = 0; i < n + 1; i++) {
                if (graph[i][num] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    connect++;
                }
            }
        }

        return connect == n;
    }
}
