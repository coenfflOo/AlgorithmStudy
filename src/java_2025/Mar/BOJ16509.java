package java_2025.Mar;
import java.util.*;
import java.lang.*;
import java.io.*;
public class BOJ16509 {
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static int[][][] dir = {{{-1,-1},{-1,1}}, {{-1,-1},{1,-1}}, {{-1,1},{1,1}}, {{1,-1},{1,1}}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int kr = Integer.parseInt(st.nextToken());
        int kc = Integer.parseInt(st.nextToken());
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[10][9];
        queue.add(new Pair(sr, sc));
        visited[sr][sc] = true;
        int cnt = -1;
        int turn = 1;
        out: while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = p.x+dx[k];
                    int y = p.y+dy[k];

                    if (x==kr&&y==kc) continue;

                    for (int d = 0; d < 2; d++) {
                        int nx = x;
                        int ny = y;
                        boolean flag = false;
                        for (int i = 0; i < 2; i++) {
                            nx += dir[k][d][0];
                            ny += dir[k][d][1];

                            if (i==0){
                                if (nx==kr&&ny==kc) flag = true;
                            }
                        }
                        if (flag) continue;

                        if (nx < 0 || ny < 0 || nx >= 10 || ny >= 9 || visited[nx][ny]) continue;

                        if (nx==kr && ny==kc) {
                            cnt = turn;
                            break out;
                        }

                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
            turn++;
        }
        System.out.println(cnt);
    }

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
