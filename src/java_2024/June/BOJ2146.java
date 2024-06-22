package java_2024.June;

import java.util.*;
import java.io.*;

public class BOJ2146 {
    static int n, island;
    static int[][] map;
    static Queue<Point> q;
    static boolean[][] visited;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        island = 1;
        visited = new boolean[n][n];
        q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    makeIsland(i, j, island++);
                }
                if (map[i][j] != 0) {
                    q.offer(new Point(i, j, map[i][j]));
                }
            }
        }

        System.out.println(makeBridge());
    }

    private static int makeBridge() {
        boolean[][][] impossible = new boolean[n][n][island];
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                impossible[p.i][p.j][p.num] = true;

                for (int k = 0; k < 4; k++) {
                    int ni = p.i + dx[k];
                    int nj = p.j + dy[k];

                    if (ni < 0 || nj < 0 || ni >= n || nj >= n || impossible[ni][nj][p.num]) {
                        continue;
                    }

                    if (map[ni][nj] == 0) {
                        impossible[ni][nj][p.num] = true;
                        q.offer(new Point(ni, nj, p.num));
                    } else if (map[ni][nj] != 0 && p.num != map[ni][nj]) {
                        return cnt;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    private static void makeIsland(int i, int j, int island) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));
        map[i][j] = island;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = p.i + dx[k];
                int nj = p.j + dy[k];

                if (ni < 0 || nj < 0 || ni >= n || nj >= n || visited[ni][nj]) {
                    continue;
                }

                if (map[ni][nj] != 0) {
                    map[ni][nj] = island;
                    visited[ni][nj] = true;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
    }

    static void printMap() {
        System.out.println("=========================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    static class Point {
        int i;
        int j;
        int num;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Point(int i, int j, int num) {
            this.i = i;
            this.j = j;
            this.num = num;
        }
    }
}
