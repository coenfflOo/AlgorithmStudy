package java_2024.Feb;

import java.util.ArrayDeque;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Queue;
        import java.util.Scanner;

public class BOJ17472 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 1, 0, 0, -1 };
    static int[] dy = { 0, -1, 1, 0 };
    static int island;
    static int V;
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][m];
        island = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
//		print();

        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
//					if (s != 0 && len >= 2) {
//						if (map[i][j] != s) {
//							bridges.add(new Bridge(s, map[i][j], len));
////							len = 0;
//						}
//					} else {
//						s = map[i][j];
////						len = 0;
//					}
                    int len = 0;
                    for (int k = 1; k < m; k++) {
                        int nj = j + dy[2] * k;
                        if (nj < m) {
                            if (map[i][nj] == 0)
                                len++;
                            else if (map[i][j] != map[i][nj] && len >= 2) {
                                bridges.add(new Bridge(map[i][j], map[i][nj], len));
                                j = nj - 1;
                                break;
                            } else
                                break;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] != 0) {
                    int len = 0;
                    for (int k = 1; k < n; k++) {
                        int ni = i + dx[0] * k;
                        if (ni < n) {
                            if (map[ni][j] == 0)
                                len++;
                            else if (map[i][j] != map[ni][j] && len >= 2) {
                                bridges.add(new Bridge(map[i][j], map[ni][j], len));
                                i = ni - 1;
                                break;
                            } else
                                break;
                        }
                    }
                }
            }
        }

//		for(Bridge b : bridges) {
//			System.out.println(b.start+" "+b.end+" "+b.length);
//		}
        Collections.sort(bridges);
        V = island - 1;

        make();

//		System.out.println("================================================");
        int min = 0;
        int cnt = 0;
        for (Bridge b : bridges) {
            if (!union(b.start, b.end)) {
                continue;
            }
//			System.out.println(b.start + " " + b.end + " " + b.length);
            min += b.length;
            if (++cnt == V - 1)
                break;
        }
//		System.out.println(cnt);

        if (cnt != V - 1)
            System.out.println("-1");
        else
            System.out.println(min);
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            map[p.i][p.j] = island;

            for (int k = 0; k < 4; k++) {
                int ni = p.i + dx[k];
                int nj = p.j + dy[k];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && map[ni][nj] != 0 && !visited[ni][nj]) {
                    map[ni][nj] = island;
                    visited[ni][nj] = true;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
        island++;
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }
    }

    static class Bridge implements Comparable<Bridge> {
        int start;
        int end;
        int length;

        public Bridge(int start, int end, int length) {
            super();
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Bridge o) {
            if (this.length > o.length)
                return 1;
            else if (this.length == o.length)
                return 0;
            return -1;
        }
    }

    static void make() {
        parents = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}