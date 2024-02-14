package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ4963 {
    static int[][] map;
    static int w;
    static int h;
    static int island;
    static int[] dx = {-1, 0, 0, 1, -1, 1, 1, -1};
    static int[] dy = {0, 1, -1, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String square;
        while (!(square = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(square);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            island = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        island++;
//                        bfs(i,j);
                        dfs(i,j);
                    }
                }
            }

            System.out.println(island);
        }
    }

    private static void dfs(int i, int j) {
        map[i][j] = 0;
        for (int k = 0; k < 8; k++) {
            int newI = i + dx[k];
            int newJ = j + dy[k];

            if (newI >= 0 && newJ >= 0 && newI < h && newJ < w && map[newI][newJ] == 1) {
                dfs(newI, newJ);
            }
        }

    }

    private static void bfs(int i, int j) {
        Queue<Island> queue = new ArrayDeque<>();
        queue.offer(new Island(i, j));
        map[i][j] = 0;
        island++;
        while (!queue.isEmpty()) {
            Island info = queue.poll();

            for (int k = 0; k < 8; k++) {
                int newI = info.h + dx[k];
                int newJ = info.w + dy[k];

                if (newI >= 0 && newJ >= 0 && newI < h && newJ < w && map[newI][newJ] == 1) {
                    queue.offer(new Island(newI, newJ));
                    map[newI][newJ] = 0;
                }
            }
        }
    }

    static class Island {
        int h;
        int w;

        Island(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
}
