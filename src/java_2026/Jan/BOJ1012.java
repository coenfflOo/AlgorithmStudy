package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M  = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            boolean[][] visited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        cnt++;
                        visited[i][j] = true;
                        Queue<Point> q = new ArrayDeque<>();
                        q.offer(new Point(i, j));
                        while (!q.isEmpty()) {
                            Point p = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = p.x + dx[k];
                                int ny = p.y + dy[k];
                                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;
                                visited[nx][ny] = true;
                                q.offer(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
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
