package java_2024.June;

import java.util.*;
import java.io.*;

public class BOJ2638 {
    static int n, m, time;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        time = 0;
        while (countingCheeze()) {
//            checkMelt();
//            printMap();
            selectMelting();
            meltCheeze();
            time++;
//            printMap();
        }

        System.out.println(time);
    }

    private static boolean countingCheeze() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt != 0;
    }

    private static void selectMelting() {
        Queue<Point> queue = new ArrayDeque<>();
        visited = new boolean[n][m];

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

                if (map[ni][nj] == 0) {
                    if (!visited[ni][nj]) {
                        queue.offer(new Point(ni, nj));
                        visited[ni][nj] = true;
                    }
                } else {
                    map[ni][nj] += 1;
                    visited[ni][nj] = true;
                }
            }
        }
    }
//
//    private static void selectMelting() {
//        Queue<Point> queue = new ArrayDeque<>();
//        visited = new boolean[n][m];
//
//        queue.offer(new Point(0,0));
//        visited[0][0] = true;
//
//        while (!queue.isEmpty()){
//            Point p = queue.poll();
//
//            for (int k = 0; k < 4; k++) {
//                int ni = p.i+dx[k];
//                int nj = p.j+dy[k];
//
//                if (ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj])
//                    continue;
//
//                if (map[ni][nj]==0||map[ni][nj]==1){
//                    queue.offer(new Point(ni,nj));
//                    visited[ni][nj] = true;
//                } else if (map[ni][nj]==2) {
//                    map[ni][nj]=1;
//                    visited[ni][nj] = true;
//                } else if (map[ni][nj]>2) {
//                    map[ni][nj]=9;
//                    visited[ni][nj] = true;
//                }
//            }
//        }
//    }


    private static void meltCheeze() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 2) {
                    map[i][j] = 0;
                } else if (map[i][j] == 2) {
                    map[i][j] = 1;
                }
            }
        }
    }

//    private static void printMap(){
//        System.out.println("=====================");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("=====================");
//    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
