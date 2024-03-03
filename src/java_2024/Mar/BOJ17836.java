package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ17836 {
    static int n, m, t;
    static int[][] map;
    static boolean[][] visited;
    static int swordTime, walkTime, resTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        resTime = 0;
        runToPrincess();
        // 6. 입력받은 t값보다 적으면 출력 아니면 fail
        if (resTime <= t) {
            System.out.println(resTime);
        } else {
            System.out.println("Fail");
        }
    }

    private static void runToPrincess() {
        Queue<Point> queue = new ArrayDeque<>();
        visited = new boolean[n][m];
        // 1. 0,0부터 bfs 돌리기
        Point start = new Point(0, 0);
        Point end = new Point(n - 1, m - 1);
        queue.offer(start);
        visited[start.i][start.j] = true;

        int walk = 0;
        boolean walkSuccess = false;
        boolean swordSuccess = false;
        out:
        while (!queue.isEmpty()) { // 2. 처음엔 방문하지 않은 0만 돌다가
            int size = queue.size();
            walk++;

            while (--size >= 0) {
                Point p = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int ni = p.i + dx[k];
                    int nj = p.j + dy[k];

                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && !visited[ni][nj] && map[ni][nj] != 1) {
                        if (map[ni][nj] == 2) {
                            // 3. 2를 만나면 sordTime 변수에 칼까지 거리 + 공주님까지 거리 더해서 keep
//                            System.out.println(walk+" "+ni+" "+nj+" "+walkTime);
                            swordSuccess = true;
                            swordTime = walk + (end.i - ni) + (end.j - nj);
//                            System.out.println("S "+swordTime);
                        }

                        if (ni == end.i && nj == end.j) {
                            walkSuccess = true;
                            walkTime = walk;
                            break out;
                        }

                        // 4. 남은 bfs 마저돌기
                        visited[ni][nj] = true;
                        queue.offer(new Point(ni, nj));
                    }
                }
            }
        }

        // 5. bfs 돈거랑 저장해둔 칼변수 비교 적은 값 구하기
        if (walkSuccess && swordSuccess) {
            if (walkTime < swordTime) {
                resTime = walkTime;
            } else {
                resTime = swordTime;
            }
        } else if (walkSuccess) {
            resTime = walkTime;
        } else if (swordSuccess) {
            resTime = swordTime;
        } else {
            resTime = Integer.MAX_VALUE;
        }
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
