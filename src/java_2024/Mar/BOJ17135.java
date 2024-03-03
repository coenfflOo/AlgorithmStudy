package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ17135 {
    static int n, m, d;
    static int[][] map;
    static int[][] copyMap;
    static List<Point> enemy;
    static List<Point> archer;
    static boolean[] selected;
    static int maxKill;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m];
        enemy = new ArrayList<>();
        archer = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            if (i != n) {
                st = new StringTokenizer(br.readLine());
            }
            for (int j = 0; j < m; j++) {
                if (i == n) {
                    map[i][j] = 2;
                    archer.add(new Point(i, j));
                } else {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        enemy.add(new Point(i, j));
                    }
                }
            }
        }

        selected = new boolean[archer.size()];
        maxKill = 0;
        combArcher(0, 0);
        System.out.println(maxKill);
    }

    private static void combArcher(int cnt, int start) {
        if (cnt == 3) {
            copyMap = new int[n + 1][m];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < m; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            // 궁수 3명 뽑음
            List<Point> selectedArcher = new ArrayList<>();
            for (int i = 0; i < archer.size(); i++) {
                if (selected[i]) {
                    selectedArcher.add(archer.get(i));
                    copyMap[archer.get(i).i][archer.get(i).j] = 3;
                }
            }

            // 게임 시작
            int killed = 0;
            while (isEnemy()) {
                // 죽일놈 찾기
                Set<Point> kill = new HashSet<>();
                for (Point a : selectedArcher) {
                    int distance = Integer.MAX_VALUE;
                    Point k = null;
                    for (Point e : enemy) {
                        int dis = Math.abs(a.i - e.i) + Math.abs(a.j - e.j);
                        if (dis <= d) {
                            if (distance > dis) {
                                distance = dis;
                                k = e;
                            } else if (k != null && distance == dis) {
                                if (k.i > e.i) {
                                    k = e;
                                }
                            }
                        }
                    }
                    if (k != null) {
                        kill.add(k);
                    }
                }

                // 죽여
                killed += kill.size();
                List<Point> newEnemy = new ArrayList<>();
                if (!kill.isEmpty()) {
                    for (Point e : enemy) {
                        for (Point k : kill) {
                            if (e.i == k.i && e.j == k.j) {
                                copyMap[e.i][e.j] = 0;
                            } else {
                                newEnemy.add(e);
                            }
                        }
                    }
                    if (!newEnemy.isEmpty())
                        enemy=newEnemy;
                }

//                for (Point p : enemy) {
//                    System.out.println("d"+p.i + " " + p.j);
//                }

                for (int i = enemy.size()-1; i >-1 ; i--) {
                    Point e = enemy.get(i);
                    copyMap[e.i][e.j] = 0;
//                    System.out.println(e.i+" "+e.j);
                    // 살아남은 적들 앞으로 한칸씩 전진
                    int ni = e.i + 1;
                    int nj = e.j;

                    if (ni < n + 1 && nj < m && copyMap[ni][nj] == 0) {
                        copyMap[ni][nj] = 1;
                        enemy.set(i, new Point(ni, nj));
                    } else {
                        enemy.remove(e);
                    }
                }
                print();
            }
            maxKill = Math.max(maxKill, killed);
            return;
        }

        if (start == archer.size()) {
            return;
        }

        selected[start] = true;
        combArcher(cnt + 1, start + 1);
        selected[start] = false;
        combArcher(cnt, start + 1);
    }

    static boolean isEnemy() {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static void print() {
        System.out.println("-------------------------------");
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(copyMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
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
