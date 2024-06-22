package java_2024.Apr;

import java.util.*;
import java.io.*;

public class BOJ17141 {
    static int n, m;
    static int[][] map;
    static List<Point> virusPoints;
    static boolean[] select;
    static int[][] copy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m == 0) {
            System.out.println(0);
            return;
        }
        map = new int[n][n];
        virusPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusPoints.add(new Point(i, j));
                }
            }
        }

        select = new boolean[virusPoints.size()];
        res = Integer.MAX_VALUE;
        combVirus(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static void combVirus(int cnt, int idx) {
        if (cnt == m) {
            copyMap();
            Queue<Point> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < virusPoints.size(); i++) {
                if (select[i]) {
                    Point p = virusPoints.get(i);
                    copy[p.i][p.j] = 3;
                    visited[p.i][p.j] = true;
                    queue.offer(p);
                }
            }

            int time = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Point p = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ni = p.i + dx[k];
                        int nj = p.j + dy[k];

                        if (ni < 0 || nj < 0 || ni >= n || nj >= n || visited[ni][nj] || copy[ni][nj] == 1
                                || copy[ni][nj] == 3) {
                            continue;
                        }

                        if (copy[ni][nj] == 0 || copy[ni][nj] == 2) {
                            copy[ni][nj] = 3;
                            visited[ni][nj] = true;
                            queue.offer(new Point(ni, nj));
                        }
                    }
                }
                time++;
            }

            if (checkZero()) {
                res = Math.min(time, res);
            }
            return;
        }

        if (idx == virusPoints.size()) {
            return;
        }

        select[idx] = true;
        combVirus(cnt + 1, idx + 1);
        select[idx] = false;
        combVirus(cnt, idx + 1);
    }

    static void copyMap() {
        copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 0 || copy[i][j] == 2) {
                    return false;
                }
            }
        }
        return true;
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
