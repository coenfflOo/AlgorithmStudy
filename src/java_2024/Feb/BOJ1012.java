package java_2024.Feb;

import java.util.*;

public class BOJ1012 {
    static int n;
    static int m;
    static int[][] ground;
    static int count;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            m = sc.nextInt();
            n = sc.nextInt();
            ground = new int[n][m];

            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                ground[y][x] = 1;
            }

            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ground[i][j] == 1) {
                        count++;
//                        bfs(i, j);
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        ground[i][j] = 0;
        while (!queue.isEmpty()) {
            Point info = queue.poll();

            for (int k = 0; k < 4; k++) {
                int newI = info.i + dx[k];
                int newJ = info.j + dy[k];

                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m && ground[newI][newJ] == 1) {
                    queue.offer(new Point(newI, newJ));
                    ground[newI][newJ] = 0;
                }
            }
        }
    }

    private static void dfs(int i, int j) {
        ground[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int newI = i + dx[k];
            int newJ = j + dy[k];

            if (newI >= 0 && newJ >= 0 && newI < n && newJ < m && ground[newI][newJ] == 1) {
                dfs(newI, newJ);
            }
        }
    }

    static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
