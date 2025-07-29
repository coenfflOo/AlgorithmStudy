package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ14716 {
    static int n,m;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int[][] map;
    static boolean[][] visited;
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

        visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||map[nx][ny]==0) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
