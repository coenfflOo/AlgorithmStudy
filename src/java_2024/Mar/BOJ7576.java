package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ7576 {
    static int n, m;
    static int[][] tomato;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tomato = new int[m][n];

        Queue<Tomato> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }

        int days = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            while (--size >= 0) {
                Tomato t = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int ni = t.i + dx[i];
                    int nj = t.j + dy[i];

                    if (ni >= 0 && nj >= 0 && ni < m && nj < n && tomato[ni][nj] == 0) {
                        tomato[ni][nj] = 1;
                        queue.offer(new Tomato(ni, nj));
                    }
                }
            }
        }
        if (!checkTomato()) {
            days = -1;
        }
        System.out.println(days);
    }

    static boolean checkTomato() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomato[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Tomato {
        int i;
        int j;

        public Tomato(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
