package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ16236 {
    static int n;
    static int[][] space;
    static boolean[][] visited;
    static Point babyShark;
    static int babySharkSize;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        space = new int[n][n];
        visited = new boolean[n][n];
        time = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    babyShark = new Point(i, j);
                    space[i][j] = 0;
                }
            }
        }

        babySharkSize = 2;
        bfsFish(babyShark);
        System.out.println(time);
    }

    private static void bfsFish(Point shark) {
        Queue<Point> queue = new ArrayDeque<>();
        Point fish = null;
        queue.offer(shark);
        space[shark.i][shark.j] = 0;
        visited[shark.i][shark.j] = true;
        int eatFish = 0;
        int day = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            fish = null;

            while (size-- > 0) {
                Point s = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int ni = s.i + dx[k];
                    int nj = s.j + dy[k];

                    if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                        if (space[ni][nj] != 0 && space[ni][nj] < babySharkSize) {
                            // 먹고 지나갈 수 있는 경우
                            visited[ni][nj] = true;
                            if (fish != null) {
                                if (fish.i > ni) {
                                    fish = new Point(ni, nj, space[ni][nj]);
                                } else if (fish.i == ni && fish.j > nj) {
                                        fish = new Point(ni, nj, space[ni][nj]);
                                }
                            } else {
                                fish = new Point(ni, nj, space[ni][nj]);
                            }
                        } else if (space[ni][nj] <= babySharkSize) {
                            // 지나만 갈 수 있는 경우
                            visited[ni][nj] = true;
                            queue.offer(new Point(ni, nj, space[ni][nj]));
                        }
                    }
                }
            }

            if (fish != null){
                eatFish ++;
                if (eatFish == babySharkSize){
                    babySharkSize++;
                    eatFish = 0;
                }
                space[fish.i][fish.j] = 0;
                visited = new boolean[n][n];
                queue.clear();
                queue.offer(new Point(fish.i, fish.j));
                visited[fish.i][fish.j] = true;
                time = day;
            }
            day++;
        }
    }

    static class Point {
        int i;
        int j;
        int size;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Point(int i, int j, int size) {
            this.i = i;
            this.j = j;
            this.size = size;
        }
    }
}
