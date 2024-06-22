package java_2024.Apr;

import java.util.*;
import java.io.*;

public class BOJ2589 {
    static int n, m;
    static String[][] map;
    static boolean[][] visited;
    static List<Point> L;
    static int res;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        L = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("L")) {
                    L.add(new Point(i, j));
                }
            }
        }

        res = Integer.MIN_VALUE;
        for (int i = 0; i < L.size(); i++) {
            bfsL(L.get(i));
        }
        System.out.println(res);
    }

    private static void bfsL(Point point) {
        int time = 0;
        visited = new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        q.offer(point);
        visited[point.i][point.j] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();

                for (int k = 0; k < 4; k++) {
                    int ni = p.i + dx[k];
                    int nj = p.j + dy[k];

                    if (ni < 0 || nj < 0 || ni >= n || nj >= m || visited[ni][nj] || map[ni][nj].equals("W")) {
                        continue;
                    }

                    q.offer(new Point(ni, nj));
                    visited[ni][nj] = true;
                }
            }
            time++;
        }
        res = Math.max(res, time - 1);
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
