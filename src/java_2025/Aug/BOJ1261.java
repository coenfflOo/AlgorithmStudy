package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1261 {
    static int n,m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        queue.offer(new Point(0,0,0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = p.i + dx[d];
                int nj = p.j + dy[d];

                if (ni<0||nj<0||ni>=n||nj>=m) continue;
//                if (ni==n-1&&nj==m-1) {
//                    min = Math.min(min, p.cnt);
//                    continue;
//                }
                if (map[ni][nj]==1){
                    if (visited[ni][nj]>p.cnt+1){
                        visited[ni][nj]=p.cnt+1;
                        queue.offer(new Point(ni,nj,p.cnt+1));
                    }
                } else {
                    if (visited[ni][nj]>p.cnt){
                        visited[ni][nj]=p.cnt;
                        queue.offer(new Point(ni,nj,p.cnt));
                    }
                }
            }
        }
        System.out.println(visited[n-1][m-1]);
    }

    static class Point {
        int i, j, cnt;
        Point(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
}
