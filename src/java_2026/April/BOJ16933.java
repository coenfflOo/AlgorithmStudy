package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ16933 {
    static int N, M, K;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        int[][][][] visited = new int[N][M][K+1][2];
        for (int[][][] a : visited)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);
        visited[0][0][0][1] = 1;
        queue.offer(new Point(0,0,0,1));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int nextTime = 1 - point.time;
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx<0||ny<0||nx>=N||ny>=M) continue;
                if(graph[nx][ny]==0){ // 벽아님,이동가능
                    if(visited[nx][ny][point.k][nextTime] == -1) {
                        visited[nx][ny][point.k][nextTime] = visited[point.x][point.y][point.k][point.time] + 1;
                        queue.offer(new Point(nx, ny, point.k, nextTime));
                    }
                } else if(point.k<K&&point.time==1){
                    if(visited[nx][ny][point.k+1][nextTime]==-1) {
                        visited[nx][ny][point.k + 1][nextTime] = visited[point.x][point.y][point.k][point.time] + 1;
                        queue.offer(new Point(nx, ny, point.k + 1, nextTime));
                    }
                } else if(point.time==0){
                    if(visited[point.x][point.y][point.k][nextTime]==-1) {
                        visited[point.x][point.y][point.k][nextTime] = visited[point.x][point.y][point.k][point.time] + 1;
                        queue.offer(new Point(point.x, point.y, point.k, nextTime));
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < 2; j++) {
                if(visited[N-1][M-1][i][j] != -1){
                    ans = Math.min(ans, visited[N-1][M-1][i][j]);
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static class Point {
        int x;
        int y;
        int k;
        int time;

        Point(int x, int y, int k, int time) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.time = time;
        }
    }
}
