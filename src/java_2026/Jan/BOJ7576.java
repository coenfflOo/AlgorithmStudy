package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ7576 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<Point> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();
        boolean zero = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (!zero &&  map[i][j] == 0) {
                    zero = true;
                }
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                }
            }
        }
        if (!zero) {
            System.out.println("0");
            return;
        }
        int days = bfsTomato();
        if (checkTomato()) {
            System.out.println(days);
        } else {
            System.out.println("-1");
        }
    }

    static int bfsTomato() {
        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point p = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || map[x][y]==-1) {
                        continue;
                    }
                    map[x][y] = 1;
                    visited[x][y] = true;
                    queue.offer(new Point(x, y));
                }
            }
            day++;
        }
        return day-1;
    }

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return false;
            }
        }
        return true;
    }
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
