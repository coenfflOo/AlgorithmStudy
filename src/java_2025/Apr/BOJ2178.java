package java_2025.Apr;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int[][] visited = new int[n][m];
        Queue<Point> q = new ArrayDeque<>();
        visited[0][0] = 1;
        q.offer(new Point(0,0));
        int cnt = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if (nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==0) continue;
                    if (visited[nx][ny]==0){
                        visited[nx][ny]=cnt;
                        q.offer(new Point(nx,ny));
                    } else if (visited[nx][ny]>cnt) {
                        visited[nx][ny]=cnt;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
            cnt++;
        }
        System.out.println(visited[n-1][m-1]);
    }

    private static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
