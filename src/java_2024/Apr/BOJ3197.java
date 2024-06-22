package java_2024.Apr;
import java.util.*;
import java.io.*;

public class BOJ3197 {
    static int[] dx={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[][] map = new String[r][c];

        Queue<Point> queue = new ArrayDeque<>();
        Queue<Point> sQueue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        boolean[][] swan = new boolean[r][c];
        Point sp = null;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals(".")||map[i][j].equals("L")) {
                    queue.add(new Point(i, j));
                    visited[i][j]=true;
                }
                if (map[i][j].equals("L")) {
                    sp = new Point(i,j);
                }
            }
        }
        System.out.println(Arrays.deepToString(map));

        sQueue.add(new Point(sp.i, sp.j));
        swan[sp.i][sp.j]=true;
        Queue<Point> nQueue = new ArrayDeque<>();
        int day = 0;
        out: while (true){
            day++;

            int qSize = queue.size();
            while (qSize-->0){
                Point p = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int ni = p.i+dx[k];
                    int nj = p.j+dy[k];

                    if (ni<0||nj<0||ni>=r||nj>=c||visited[ni][nj])
                        continue;

                    if (map[ni][nj].equals("X")){
                        map[ni][nj] = ".";
                        visited[ni][nj]=true;
                        queue.offer(new Point(ni,nj));
                    } else if (map[ni][nj].equals(".")||map[ni][nj].equals("L")) {
                        visited[ni][nj]=true;
                        queue.offer(new Point(ni,nj));
                    }
                }
            }

            while (!sQueue.isEmpty()){
                Point p = sQueue.poll();
                for (int k = 0; k < 4; k++) {
                    int ni = p.i+dx[k];
                    int nj = p.j+dy[k];

                    if (ni<0||nj<0||ni>=r||nj>=c||swan[ni][nj])
                        continue;

                    if (map[ni][nj].equals("X")){
                        swan[ni][nj]=true;
                        nQueue.offer(new Point(ni,nj));
                    } else if (map[ni][nj].equals(".")) {
                        swan[ni][nj]=true;
                        queue.offer(new Point(ni,nj));
                    } else if (map[ni][nj].equals("L")) {
                        break out;
                    }
                }
            }
            Queue<Point> tmp = sQueue;
            sQueue = nQueue;
            nQueue = tmp;
        }
        System.out.println(day);
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
