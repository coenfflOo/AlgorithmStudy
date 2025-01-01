package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    private static int n;
    private static int[][] graph;
    private static boolean[][] visited;
    private static Queue<Point> q;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rain = 0;
        int maxSafe = 0;
        while(rain!=100){
            int safe = 0;
            q = new ArrayDeque<>();
            visited = new boolean[n+1][n+1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > rain && !visited[i][j]) {
                        visited[i][j] = true;
                        findMax(i, j, rain);
                        safe++;
                    }
                }
            }
//            System.out.println(rain);
//            print();
            if (safe > maxSafe)
                maxSafe = safe;
            rain++;
        }

        System.out.println(maxSafe);
    }

    private static void findMax(int i, int j, int rain) {
        q.add(new Point(i,j));
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                visited[p.x][p.y] = true;

                for (int k = 0; k < 4; k++) {
                    int ni = p.x + dx[k];
                    int nj = p.y + dy[k];

                    if (ni < 0 || nj < 0 || ni >= n || nj >= n || visited[ni][nj]) {
                        continue;
                    }

                    if (graph[ni][nj] > rain) {
                        visited[ni][nj] = true;
                        q.offer(new Point(ni, nj));
                    }
                }
            }
        }
    }

    private static void print(){
        System.out.println("---------------------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j])
                    System.out.print("O ");
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------");
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
