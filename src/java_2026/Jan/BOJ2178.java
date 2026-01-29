package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ2178 {
    static int N,M;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static String[][] miro;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new String[N][M];
        for (int i = 0; i < N; i++) {
            miro[i] = br.readLine().split("");
        }
        System.out.println(bfsMiro());
    }

    static int bfsMiro(){
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new Point(0,0,1));
        while (!q.isEmpty()) {
            Point p = q.poll();
            for(int k=0; k<4; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || miro[nx][ny].equals("0"))
                    continue;
                if (nx==N-1 && ny==M-1){
                    return p.cnt+1;
                }
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny,p.cnt+1));
            }
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
