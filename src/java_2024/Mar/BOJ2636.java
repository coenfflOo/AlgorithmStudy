package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ2636 {
    static int n, m;
    static int[][] cheeze;
    static int time, melting;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheeze = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        time = 0;
        while (true) {
            if (countCheeze() == 0) {
                break;
            }

            melting = countCheeze();
            bfsCheeze();
            melt();
            time++;
        }

        System.out.println(time);
        System.out.println(melting);
    }

    private static void bfsCheeze() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = p.i + dx[k];
                int nj = p.j + dy[k];

                if (ni < 0 || nj < 0 || ni >= n || nj >= m) {
                    continue;
                }
                if (cheeze[ni][nj] == 0 && !visited[ni][nj]) {
                    queue.offer(new Point(ni, nj));
                    visited[ni][nj] = true;
                } else if (cheeze[ni][nj] == 1) {
                    cheeze[ni][nj] = 2;
                }
            }
//            print();
        }

    }

    private static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheeze[i][j] == 2) {
                    cheeze[i][j] = 0;
                }
            }
        }
    }

    static int countCheeze() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheeze[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void print() {
        System.out.println("=======================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cheeze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
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
