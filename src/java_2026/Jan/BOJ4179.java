package java_2026.Jan;
import java.util.*;
import java.io.*;

public class BOJ4179 {
    static int R, C;
    static String[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<Point> jq,fq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];
        jq = new ArrayDeque<>();
        fq = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = str[j];
                if (map[i][j].equals("J")) {
                    visited[i][j] = true;
                    jq.offer(new Point(i, j, "J"));
                } else if (map[i][j].equals("F")) {
                    visited[i][j] = true;
                    fq.offer(new Point(i, j, "F"));
                }
            }
        }

        int day = 1;
        while (!jq.isEmpty()) {
            int size  = fq.size();
            while (size-- > 0) {
                Point p = fq.poll();
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x < 0 || x >= R || y < 0 || y >= C || visited[x][y] || map[x][y].equals("#")) continue;
                    visited[x][y] = true;
                    map[x][y] = "F";
                    fq.offer(new Point(x,y, "F"));
                }
            }
            size = jq.size();
            while (size-- > 0) {
                Point p = jq.poll();
                if (p.x == 0 || p.y == 0 || p.x == R - 1 || p.y == C - 1) {
                    System.out.println(day);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x < 0 || x >= R || y < 0 || y >= C || visited[x][y] || map[x][y].equals("#") || map[x][y].equals("F")) continue;
//                    if (x==0||y==0||x==R-1||y==C-1) {
////                        for (int k = 0; k < R; k++) {
////                            System.out.println(Arrays.toString(map[k]));
////                        }
//                        System.out.println(day+1);
//                        return;
//                    }
                    visited[x][y] = true;
                    map[x][y] = "J";
                    jq.offer(new Point(x,y, "J"));
                }
            }
            day++;
        }
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        System.out.println("IMPOSSIBLE");
    }

    static class Point{
        int x;
        int y;
        String s;
        public Point(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}
