package java_2024.Mar;

import java.util.*;
import java.io.*;

class BOJ17135 {
    static int n, m, d;
    static int[][] originalMap;
    static int[] archer;
    static boolean[][] killMap;
    static int res;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();

        originalMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = sc.nextInt();
            }
        }

        res = 0;
        archer = new int[3];
        combArcher(0, 0);
        System.out.println(res);
    }

    private static void combArcher(int cnt, int idx) {
        if (cnt == 3) {
            // 배열 복사
            int[][] copyMap = copyOfOriginal();
            int ans = 0;

            // 적이 없을 떄 까지 게임진행
            while (!noEnemy(copyMap)) {
                killMap = new boolean[n][m];

                for (int i = 0; i < 3; i++) { // 궁수별로 돌면서
                    // 죽일 적을 골라야지
                    int distance = Integer.MAX_VALUE;
                    Point p = null;
                    for (int j = n - 1; j > -1; j--) {
                        for (int k = 0; k < m; k++) {
                            if (copyMap[j][k] == 1) {
//                                System.out.println(distance);
                                int dis = calDistance(j, k, archer[i]);
                                if (dis <= d) {
                                    if (distance > dis) {
                                        distance = dis;
                                        p = new Point(j, k);
                                    } else if (distance == dis) {
                                        if (p != null) {
                                            if (p.j > k) {
                                                p = new Point(j, k);
                                            }
                                        } else {
                                            p = new Point(j, k);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (p != null) {
                        killMap[p.i][p.j] = true;
                    }
                }

//                print(copyMap);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (killMap[i][j]) {
                            copyMap[i][j] = 0;
                            ans++;
                        }
                    }
                }

                for (int i = n - 2; i >= 0; i--) {
                    for (int j = 0; j < m; j++) {
                        copyMap[i + 1][j] = copyMap[i][j];
                    }
                }
                for (int i = 0; i < m; i++) {
                    copyMap[0][i] = 0;
                }
            }
//            System.out.println(ans);
            res = Math.max(res, ans);
            return;
        }

        if (idx == m) {
            return;
        }

        archer[cnt] = idx; // 이번 나의 타겟 써보는 중임
        combArcher(cnt + 1, idx + 1);
        combArcher(cnt, idx + 1);
    }

    private static int calDistance(int j, int k, int i) {
        return Math.abs(n - j) + Math.abs(i - k);
    }

    private static boolean noEnemy(int[][] copyMap) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] copyOfOriginal() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = originalMap[i][j];
            }
        }
        return copy;
    }

    static void print(int[][] arr) {
        System.out.println("----------------------------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
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