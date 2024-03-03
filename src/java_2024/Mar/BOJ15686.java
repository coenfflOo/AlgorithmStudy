package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ15686 {
    static int n, m;
    static int[][] map;
    static List<Point> chicken;
    static boolean[] selected;
    static List<Point> house;
    static int minChickenLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        selected = new boolean[chicken.size()];
        minChickenLength = Integer.MAX_VALUE;
        chickenComb(0, 0);
        System.out.println(minChickenLength);
    }

    private static void chickenComb(int cnt, int start) {
        if (cnt == m) {
            List<Point> selectedChicken = new ArrayList<>();
            for (int i = 0; i < chicken.size(); i++) {
                if (selected[i]) {
                    selectedChicken.add(chicken.get(i));
                }
            }
            int sum = 0;
            for (Point h : house) {
                int len = Integer.MAX_VALUE;
                for (int i = 0; i < selectedChicken.size(); i++) {
                    Point c = selectedChicken.get(i);
                    int l = Math.abs(h.i - c.i) + Math.abs(h.j - c.j);
                    len = Math.min(len, l);
                }
                sum += len;
            }
            minChickenLength = Math.min(minChickenLength, sum);
        }

        if (start == chicken.size()) {
            return;
        }

        selected[start] = true;
        chickenComb(cnt + 1, start + 1);
        selected[start] = false;
        chickenComb(cnt, start + 1);
    }

    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
