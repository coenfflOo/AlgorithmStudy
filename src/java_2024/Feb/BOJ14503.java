package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ14503 {
    static int n, m, r, c, d;
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        visited[r][c] = true;
        room[r][c] = -1;
        cnt = 1;
        cleaning(r, c, d);
        System.out.println(cnt);
    }

    private static void cleaning(int i, int j, int dir) {
//        if (i < 0 || i >= n || j < 0 || j >= m || room[i][j] == 1) {
//            return;
//        }
//
//        if (!checkClean(i, j)) { // 빈 칸이 없는 경우
//            cleaning(i + dx[(dir + 2) % 4], j + dy[(dir + 2) % 4], dir);
//        } else { // 빈 칸이 있는 경우
//            for (int k = 0; k < 4; k++) {
//                dir = (4 + dir - 1) % 4;
//                int robotI = i + dx[dir];
//                int robotJ = j + dy[dir];
//                if (robotI >= 0 && robotJ >= 0 && robotI < n && robotJ < m && !visited[robotI][robotJ]
//                        && room[robotI][robotJ] == 0) {
//                    visited[robotI][robotJ] = true;
//                    cleaning(robotI, robotJ, dir);
//                    cnt++;
//                    return;
//                }
//            }
//        }
        for (int k = 0; k < 4; k++) {
            dir = (dir + 3) % 4;
            int ai = i + dx[dir];
            int aj = j + dy[dir];

            if (ai>=0&&ai<n&&aj>=0&&aj<m&&room[ai][aj]==0){
                room[ai][aj] = -1;
                cnt++;
                cleaning(ai,aj,dir);
                return;
            }
        }

        int back = (dir+2)%4;
        int bi = i + dx[back];
        int bj = j + dy[back];

        if (room[bi][bj] != 1){
            cleaning(bi,bj,dir);
        }
    }

    private static boolean checkClean(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int newi = i + dx[k];
            int newj = j + dy[k];

            if (newi >= 0 && newi < n && newj >= 0 && newj < m && room[newi][newj] == 0 && !visited[newi][newj]) {
                return true;
            }
        }
        return false;
    }
}
