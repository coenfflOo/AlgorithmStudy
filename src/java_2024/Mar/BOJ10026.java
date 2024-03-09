package java_2024.Mar;
import java.util.*;
import java.io.*;

public class BOJ10026 {
    static int n;
    static String[][] picture;
    static boolean[][] visitedNormal;
    static boolean[][] visitedSpecial;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        picture = new String[n][n];
        for (int i = 0; i < n; i++) {
            picture[i] = br.readLine().split("");
        }

        visitedNormal = new boolean[n][n];
        visitedSpecial = new boolean[n][n];

        int normal = 0;
        int special = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedNormal[i][j]){
                    bfsNormal(i,j);
                    normal++;
                }
                if (!visitedSpecial[i][j]){
                    bfsSpecial(i,j);
                    special++;
                }
            }
        }
        System.out.println(normal+" "+special);
    }

    private static void bfsSpecial(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i,j));
        visitedNormal[i][j]= true;

        while (!queue.isEmpty()){
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = p.i+dx[k];
                int nj = p.j+dy[k];

                if (ni>=0&&nj>=0&&ni<n&&nj<n&&checkOther(i,j,ni,nj)&&!visitedSpecial[ni][nj]){
                    visitedSpecial[ni][nj] = true;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
    }


    private static void bfsNormal(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i,j));
        visitedNormal[i][j] = true;
        while (!queue.isEmpty()){
            Point p = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ni = p.i+dx[k];
                int nj = p.j+dy[k];

                if (ni>=0&&nj>=0&&ni<n&&nj<n&&picture[i][j].equals(picture[ni][nj])&&!visitedNormal[ni][nj]){
                    visitedNormal[ni][nj] = true;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
    }

    private static boolean checkOther(int i, int j, int ni, int nj) {
        if (picture[i][j].equals("R")||picture[i][j].equals("G")){
            return picture[ni][nj].equals("R") || picture[ni][nj].equals("G");
        } else {
            return picture[ni][nj].equals("B");
        }
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
