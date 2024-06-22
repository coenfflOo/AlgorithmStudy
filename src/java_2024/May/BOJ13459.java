package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ13459 {
    static int n, m;
    static String[][] map;
    static int[][] current;
    //    static boolean possible;
    static int[] dx = {-1, 1, 0, 0}; // 위 아래 왼 오
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        List<Point> marble = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                switch (map[i][j]) {
                    case "R":
                        marble.add(new Point(i, j, "R"));
                        break;
                    case "B":
                        marble.add(new Point(i, j, "B"));
                        break;
                }
            }
        }

        count = Integer.MAX_VALUE;
        combDir(1, marble, map);
        if (count == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }

    private static void combDir(int cnt, List<Point> marble, String[][] graph) {
        if (cnt == 11) {
//            System.out.println("dd");
            return;
        }

        for (int d = 0; d < 4; d++) {
            // 구슬 이동시켜
            String[][] copy = copyMap(graph);
//            System.out.println("kk");
            List<Point> newMarble = new ArrayList<>();
//            System.out.println(marble);
            for (Point p : marble) {
                newMarble.add(new Point(p.i, p.j, p.color));
            }
            newMarble = moveMarble(copy, newMarble, d);
            // 구슬 확인
            current = new int[2][1];
            checkMarble(copy);
//            System.out.println("cur: "+current[0][0]+" "+current[1][0]);
            if (current[0][0] == 1 && current[1][0] == 1) {
                combDir(cnt + 1, newMarble, copy);
            } else if (current[0][0] == 0 && current[1][0] == 1) { // 파란 구슬만 존재
//                System.out.println(cnt);
//                printMap(copy);
                count = Math.min(count, cnt);
            }
        }
    }

    private static List<Point> moveMarble(String[][] copy, List<Point> marble, int dir) {
        // 벽을 만나거나 구멍을 만날떄까지 한방향으로 이동해야해
        // 자기와 또 다른 구슬을 만나면 그 옆까지 이동해야만..
//        System.out.println("direction: "+dir);
//        List<Point> rm = new ArrayList<>();
//        printMap(copy);
        switch (dir) {
            case 0:
                Collections.sort(marble, (o1, o2) -> o1.i - o2.i);
                break;
            case 1:
                Collections.sort(marble, (o1, o2) -> o2.i - o1.i);
                break;
            case 2:
                Collections.sort(marble, (o1, o2) -> o1.j - o2.j);
                break;
            case 3:
                Collections.sort(marble, (o1, o2) -> o2.j - o1.j);
                break;
        }
        for (Point mp : marble) {
//            System.out.println(mp);
            while (true) {
                copy[mp.i][mp.j] = ".";
                int ni = mp.i + dx[dir];
                int nj = mp.j + dy[dir];
//            System.out.println("dd: "+mp+" //"+ni+" "+nj);
                if (copy[ni][nj].equals(".")) {
                    copy[ni][nj] = mp.color;
                    mp.i = ni;
                    mp.j = nj;
                } else if (copy[ni][nj].equals("O")) {
//                    rm.add(mp);
                    break;
                } else {
                    copy[mp.i][mp.j] = mp.color;
                    break;
                }
//                System.out.println(mp.i+" "+mp.j);
            }
//            printMap(copy);
        }
//        marble.removeAll(rm);
//        printMap(copy);
        return marble;
    }

    private static void checkMarble(String[][] copy) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j].equals("R")) {
                    current[0][0] = 1;
                } else if (copy[i][j].equals("B")) {
                    current[1][0] = 1;
                }
            }
        }
    }

    private static String[][] copyMap(String[][] graph) {
        String[][] copy = new String[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(graph[i], m);
        }
        return copy;
    }

    static void printMap(String[][] graph) {
        System.out.println("===================================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===================================");
    }

    static class Point {
        int i;
        int j;
        String color;

        public Point(int i, int j, String color) {
            this.i = i;
            this.j = j;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
