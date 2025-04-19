package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1520 {
    private static int n,m;
    private static int[][] map;
    private static int[][] cnt;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,-1,0,1};
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
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cnt[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(cnt[n-1][m-1]);
    }

    private static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        cnt = new int[n][m];
        queue.add(new Point(0, 0, map[0][0]));
        cnt[0][0] = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx<0||ny<0||nx>=n||ny>=m||map[p.x][p.y]<=map[nx][ny]) continue;
                if (cnt[nx][ny]==0){
                    queue.add(new Point(nx,ny,map[nx][ny]));
                }
                cnt[nx][ny] += cnt[p.x][p.y];
            }
        }
    }

    private static class Point implements Comparable<Point> {
        int x, y, h;
        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Point o) {
            return o.h - this.h;
        }
    }
}
