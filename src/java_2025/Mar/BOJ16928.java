package java_2025.Mar;

import java.util.*;
import java.io.*;

public class BOJ16928 {
    private static Point[][] map;
    private static int[] move = {1,2,3,4,5,6};
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new Point[100][100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int ai = a / 10;
            int aj = a % 10;
            int bi = b / 10;
            int bj = b % 10;
            map[ai][aj] = new Point(b,bi,bj);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int ai = a / 10;
            int aj = a % 10;
            int bi = b / 10;
            int bj = b % 10;
            map[ai][aj] = new Point(b,bi,bj);
        }

        cnt = 0;
        playGame();
        System.out.println(cnt);
    }

    private static void playGame() {
        boolean[][] visited = new boolean[10][10];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                for (int k = 0; k < 6; k++) {
                    int next = cur + move[k];
                    int ni = next/10;
                    int nj = next%10;

                    if (visited[ni][nj]) continue;
                    visited[ni][nj] = true;
                    if(ni==9&&nj==9){
                        cnt++;
                        return;
                    } else if (map[ni][nj]!= null){
                        Point p = map[ni][nj];
                        if (visited[p.ni][p.nj]) continue;
                        queue.add(p.next);
                    } else {
                        queue.add(next);
                    }
                }
            }
            cnt++;
        }
    }

    static class Point {
         int next;
         int ni;
         int nj;
         public Point(int next, int ni, int nj) {
             this.next = next;
             this.ni = ni;
             this.nj = nj;
         }
    }
}
