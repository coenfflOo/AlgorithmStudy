package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ14502 {
    static int n, m;
    static int[][] lab;
    static List<Point> zeros;
    static boolean[] selected;
    static boolean[][] visited;
    static int maxCnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];
        zeros = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    zeros.add(new Point(i, j));
                }
            }
        }
        selected = new boolean[zeros.size()];

        maxCnt = 0;
        buildComb(0, 0);
        System.out.println(maxCnt);
    }

    static void buildComb(int cnt, int start) {
        if (cnt == 3) {
            // 배열 복사
            int[][] copyLab = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyLab[i][j] = lab[i][j];
                }
            }
            // 벽세우기
            for (int i = 0; i < zeros.size(); i++) {
                if (selected[i]) {
                    Point p = zeros.get(i);
                    copyLab[p.i][p.j] = 1;
                }
            }
            // 바이러스 퍼뜨리기
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyLab[i][j] == 2) {
                        bfsVirus(i, j, copyLab);
                    }
                }
            }
            // 안전 영역 카운팅
            int safe = checkZero(copyLab);
            maxCnt = Math.max(maxCnt, safe);
            return;
        }
        if (start == zeros.size()) {
            return;
        }

        selected[start] = true;
        buildComb(cnt + 1, start + 1);
        selected[start] = false;
        buildComb(cnt, start + 1);
    }

    private static void bfsVirus(int i, int j, int[][] copyLab) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = p.i + dx[k];
                int nj = p.j + dy[k];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && copyLab[ni][nj] == 0) {
                    copyLab[ni][nj] = 2;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
    }

    private static int checkZero(int[][] copyLab) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyLab[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
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
