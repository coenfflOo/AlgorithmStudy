package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ14500 {
    static int n, m;
    static int[][] paper;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int max;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                findMaxValue(i, j, 1, paper[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void findMaxValue(int i, int j, int cnt, int sum) {
        if (cnt == 4) {
//            for (int k = 0; k < n; k++) {
//                for (int l = 0; l < m; l++) {
//                    if (visited[k][l]) {
//                        System.out.print(paper[k][l]+" ");
//                    }
//                }
//                System.out.println();
//            }
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int newi = i + dx[k];
            int newj = j + dy[k];

            if (newi >= 0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj]) {
                if (cnt == 2) {
                    visited[newi][newj] = true;
                    findMaxValue(i, j, cnt + 1, sum + paper[newi][newj]);
                    visited[newi][newj] = false;
                }

                visited[newi][newj] = true;
                findMaxValue(newi, newj, cnt + 1, sum + paper[newi][newj]);
                visited[newi][newj] = false;
            }
        }
    }
}
