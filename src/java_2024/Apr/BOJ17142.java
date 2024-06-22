package java_2024.Apr;

import java.util.*;
import java.io.*;

public class BOJ17142 {
    static int n, m;
    static int[][] lab;
    static int[][] labCopy;
    static List<Point> virus;
    static Queue<Point> startVirus;
    static int time;
    static int resMinTime;
    static int[] result;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][n];
        virus = new ArrayList<>();
        boolean isZero = false;
        zero = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new Point(i, j));
                } else if (lab[i][j] == 1) {
                    lab[i][j] = -1;
                } else {
                    isZero = true;
                    zero++;
                }
            }
        }

        if (!isZero) {
            System.out.println("0");
            return;
        }

        resMinTime = Integer.MAX_VALUE;
        result = new int[m];
        combVirus(0, 0);
        if (resMinTime == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(resMinTime);
        }
    }

    private static void combVirus(int cnt, int target) {
        if (cnt == m) {
            copyMap();
            startVirus = new ArrayDeque<>();
            visited = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                Point p = virus.get(result[i]);
                startVirus.offer(p);
                visited[p.i][p.j] = true;
            }

            time = bfsVirus();
//            printMap();
            if (checkZero()) {
                resMinTime = Math.min(time, resMinTime);
            }
            return;
        }

        if (target == virus.size()) {
            return;
        }

        result[cnt] = target;
        combVirus(cnt + 1, target + 1);
        combVirus(cnt, target + 1);
    }

    private static int bfsVirus() {
        int count = zero;
        int time = 0;
        while (!startVirus.isEmpty()) {
            int size = startVirus.size();
            time++;

            while (size-- > 0) {
                Point p = startVirus.poll();

                for (int k = 0; k < 4; k++) {
                    int ni = p.i + dx[k];
                    int nj = p.j + dy[k];

                    if (ni < 0 || nj < 0 || ni >= n || nj >= n || labCopy[ni][nj] == -1 || visited[ni][nj]) {
                        continue;
                    }

                    // 0을 만나면
                    if (labCopy[ni][nj] == 0) {
                        labCopy[ni][nj] = 3;
                        visited[ni][nj] = true;
                        count--;
                        startVirus.offer(new Point(ni, nj));
                    }

                    if (labCopy[ni][nj] == 2) {
                        visited[ni][nj] = true;
                        startVirus.offer(new Point(ni, nj));
                    }
                }
            }
            if (count == 0) {
                return time;
            }
        }
        return 0;
    }

    private static void copyMap() {
        labCopy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                labCopy[i][j] = lab[i][j];
            }
        }
    }

    static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (labCopy[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printMap() {
        System.out.println("======================================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(labCopy[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("======================================");
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
