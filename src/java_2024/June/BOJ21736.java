package java_2024.June;
import java.util.*;
import java.io.*;

public class BOJ21736 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] map = new String[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("I")) {
                    queue.offer(new Point(i, j));
                    visited[i][j]=true;
                }
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ni = p.i+dx[k];
                int nj = p.j+dy[k];

                if (ni<0||nj<0||ni>=n||nj>=m||visited[ni][nj])
                    continue;

                if (map[ni][nj].equals("O")){
                    visited[ni][nj]=true;
                    queue.offer(new Point(ni,nj));
                } else if (map[ni][nj].equals("P")){
                    cnt++;
                    visited[ni][nj]=true;
                    queue.offer(new Point(ni,nj));
                }
            }
        }

        if(cnt==0)
            System.out.println("TT");
        else System.out.println(cnt);
    }

    static class Point{
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
