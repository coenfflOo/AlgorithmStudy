package java_2024.May;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ5427 {
    static int w,h;
    static String[][] building;
    static Queue<Point> fires;
    static int time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            w = Integer.parseInt(br.readLine());
            h = Integer.parseInt(br.readLine());
            building = new String[h][w];

            fires = new ArrayDeque<>();
            Point now = null;
            for (int i = 0; i < h; i++) {
                building[i]=br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    if (building[i][j].equals("@"))
                        now = new Point(i,j);
                    else if (building[i][j].equals("*")) {
                        fires.add(new Point(i,j));
                    }
                }
            }

            time = 0;
//            if (exitBuilding(now)){
//                System.out.println(time);
//            } else {
//                System.out.println("IMPOSSIBLE");
//            }
        }
    }

//    private static boolean exitBuilding(Point now) {
//        Queue<Point> queue = new ArrayDeque<>();
//        queue.offer(now);
//        boolean[][] visited = new boolean[h][w];
//
//        while (!queue.isEmpty()){
//            int size;
//        }
//    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
