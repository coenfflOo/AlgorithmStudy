package java_2024.Apr;

import java.util.*;
import java.io.*;

public class BOJ1600 {
    static int k, w, h;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] horseX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] horseY = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int cnt;
    static boolean done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        done = false;
        bfsMonkey();
        if (done) {
            System.out.println(cnt + 1);
        } else {
            System.out.println("-1");
        }
    }

    private static void bfsMonkey() {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[k + 1][h][w];
        queue.add(new Pair(0, 0, 0));
        visited[0][0][0] = true;

        if (h == 1 && w == 1) {
            cnt = -1;
            done = true;
            return;
        }

        out:
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair p = queue.poll();
                for (int c = 0; c < 4; c++) {
                    int ni = p.i + dx[c];
                    int nj = p.j + dy[c];
                    int jump = p.jump;

                    if (ni < 0 || nj < 0 || ni >= h || nj >= w || visited[jump][ni][nj] || map[ni][nj] == 1) {
                        continue;
                    }

                    queue.add(new Pair(ni, nj, jump));
                    visited[jump][ni][nj] = true;
                    if (ni == h - 1 && nj == w - 1) {
                        done = true;
                        break out;
                    }
                }

                for (int c = 0; c < 8; c++) {
                    int ni = p.i + horseX[c];
                    int nj = p.j + horseY[c];
                    int jump = p.jump + 1;
                    if (jump >= k + 1) {
                        break;
                    }

                    if (ni < 0 || nj < 0 || ni >= h || nj >= w || visited[jump][ni][nj] || map[ni][nj] == 1) {
                        continue;
                    }

                    queue.add(new Pair(ni, nj, jump));
                    visited[jump][ni][nj] = true;
                    if (ni == h - 1 && nj == w - 1) {
                        done = true;
                        break out;
                    }
                }
            }
            cnt++;
        }
    }

    static class Pair {
        int i;
        int j;
        int jump;

        public Pair(int i, int j, int jump) {
            this.i = i;
            this.j = j;
            this.jump = jump;
        }
    }
}
