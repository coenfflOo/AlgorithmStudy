package java_2025.Jun;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ31575 {
    private static int n,m;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        visited[0][0] = true;
        queue.offer(new Point(0,0));
        int[] dx = {1,0};
        int[] dy = {0,1};
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 2; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.offer(new Point(nx,ny));
            }
        }
        if (visited[n-1][m-1]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
