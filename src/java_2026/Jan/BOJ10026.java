package java_2026.Jan;

import java.util.*;
import java.io.*;

public class BOJ10026 {
    static int N;
    static String[][] map;
    static boolean[][] visitedNormal;
    static boolean[][] visitedRG;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visitedNormal = new boolean[N][N];
        visitedRG = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = str[j];
            }
        }

        int cnt = 0;
        int rg = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    cnt++;
                    bfsNormal(i, j);
                }
                if (!visitedRG[i][j]) {
                    rg++;
                    bfsRG(i,j);
                }
            }
        }
        System.out.println(cnt+" "+rg);
    }

    static void bfsNormal(int i, int j) {
        visitedNormal[i][j] = true;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = p.x + dx[k];
                int y = p.y + dy[k];
                if (x < 0 || y < 0 || x >= N || y >= N || visitedNormal[x][y] || !map[p.x][p.y].equals(map[x][y])) {
                    continue;
                }
                visitedNormal[x][y] = true;
                q.offer(new Point(x, y));
            }
        }
    }

    static void bfsRG(int i, int j) {
        visitedRG[i][j] = true;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(i, j));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int k = 0; k < 4; k++) {
                int x = p.x + dx[k];
                int y = p.y + dy[k];
                if (x < 0 || y < 0 || x >= N || y >= N || visitedRG[x][y]) {
                    continue;
                }
                if (map[p.x][p.y].equals("B")&& (map[x][y].equals("R")||map[x][y].equals("G"))) continue;
                else if (map[p.x][p.y].equals("R") && map[x][y].equals("B")) continue;
                else if (map[p.x][p.y].equals("G") && map[x][y].equals("B")) continue;
                visitedRG[x][y] = true;
                q.offer(new Point(x, y));
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
