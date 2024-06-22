package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ7562 {
    static int n;
    static boolean[][] visited;
    static Point end;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(moveKnight(start));
        }
    }

    private static int moveKnight(Point start) {
        if (start.i == end.i && start.j == end.j) {
            return 0;
        }
        Queue<Point> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.i][start.j] = true;

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                if (p.i == end.i && p.j == end.j) {
                    return time;
                }

                for (int d = 0; d < 8; d++) {
                    int ni = p.i + dx[d];
                    int nj = p.j + dy[d];
                    if (ni < 0 || nj < 0 || nj >= n || ni >= n || visited[ni][nj]) {
                        continue;
                    }

                    visited[ni][nj] = true;
                    q.offer(new Point(ni, nj));
                }
            }
            time++;
        }
        return 0;
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
