package java_2024.Apr;

import java.util.*;
import java.io.*;
import java_2024.Apr.BOJ17142.Point;

public class BOJ2116 {
    static int n;
    static int[][] map;
    static Queue<Point> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j]==2){
                    queue.offer(new Point(i,j,0));
                }
            }
        }


    }

    static class Point{
        int i;
        int j;
        int t;

        public Point(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}
