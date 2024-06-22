package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ17135 {
    static int n, m, d;
    static int[][] map;
    static int[][] copy;
    static List<Point> enemy;
    static List<Point> archer;
    static List<Point> copyEnemy;
    static int deadEnemy;
    static int dead;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m];
        enemy = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    enemy.add(new Point(i, j));
                }
            }
        }

        dead = 0;
        combArcher(0, 0);
        System.out.println(dead);
    }

    private static void combArcher(int cnt, int idx) {
        if (cnt == 3) {
            // 궁수 배치
            archer = new ArrayList<>();
            copyEnemy = new ArrayList<>(enemy);
            Collections.sort(copyEnemy);
            copyMap();

            deadEnemy = 0;
            // 적이 없을떄까지 반복
            while (checkEnemy() != 0) {
                // 궁수가 죽일 적 찾기 -> 큐에 담기
                killEnemy();
                // 적들이 내려온다아ㅏ
                moveEnemy();
            }
            dead = Math.max(deadEnemy, dead);
            return;
        }

        if (idx == m) {
            return;
        }

        map[n][idx] = 3;
        combArcher(cnt + 1, idx + 1);
        map[n][idx] = 0;
        combArcher(cnt, idx + 1);
    }

    private static void killEnemy() {
        for (Point a : archer) {
            int dix = Integer.MAX_VALUE;
            Point die = null;
            for (Point e : copyEnemy) {
                int distance = Math.abs(a.i - e.i) + Math.abs(a.j - e.j);
//                System.out.println(distance+" "+d);
                if (d >= distance) {
                    if (dix > distance) {
                        dix = distance;
                        die = e;
                    } else if (dix == distance && die.j > e.j) {
                        die = e;
                    }
                }
            }

            if (die != null) {
                if (copy[die.i][die.j] == 1) {
                    deadEnemy++;
                    copy[die.i][die.j] = 0;
                }
            }
        }
    }

    private static void moveEnemy() {
//        printMap(copy);
        copyEnemy.clear();
        for (int i = n - 1; i > 0; i--) {
            copy[i] = Arrays.copyOf(copy[i - 1], m);
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 1) {
                    copyEnemy.add(new Point(i, j));
                }
            }
        }
        Arrays.fill(copy[0], 0);
    }

    private static int checkEnemy() {
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void copyMap() {
        copy = new int[n + 1][m];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
                if (copy[i][j] == 3) {
                    archer.add(new Point(i, j));
                }
            }
        }
    }

    static void printMap(int[][] graph) {
        System.out.println("===================================");
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===================================");
    }

    static class Point implements Comparable<Point> {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Point o) {
            if (this.i == o.i) {
                return this.j - o.j;
            }
            return o.i - this.i;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
