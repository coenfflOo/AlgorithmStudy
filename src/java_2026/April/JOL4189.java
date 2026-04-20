package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class JOL4189 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int malx = Integer.parseInt(st.nextToken())-1;
        int maly = Integer.parseInt(st.nextToken())-1;
        int jolx = Integer.parseInt(st.nextToken())-1;
        int joly = Integer.parseInt(st.nextToken())-1;

        if (malx == jolx && maly == joly) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{malx, maly});
        visited[malx][maly] = true;
        int[] dx = {-1,-2,-2,-1,1,2,2,1};
        int[] dy = {-2,-1,1,2,2,1,-1,-2};
        int ans = 0;
        out: while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int k = 0; k < 8; k++) {
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];

                    if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;

                    if(nx==jolx&&ny==joly) break out;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        System.out.println(ans);
    }
}
