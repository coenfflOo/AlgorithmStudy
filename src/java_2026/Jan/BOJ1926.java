package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ1926 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visited;
    static int n,m,max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i, j));
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = p.x + dx[k];
                int y = p.y + dy[k];
                if (x<0||x>=n||y<0||y>=m||visited[x][y]||graph[x][y]==0) continue;
                visited[x][y] = true;
                max = Math.max(max,++cnt);
                queue.add(new Point(x, y));
            }
        }
        max = Math.max(max,cnt);
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
