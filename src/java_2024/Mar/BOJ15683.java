package java_2024.Mar;

import java.util.*;
import java.io.*;

public class BOJ15683 {
    static int n, m;
    static int[][] office;
    static int[][] copyOffice;
    static int[] cameraDir;
    static List<CCTV> camera;
    static int resMin;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    private static final int[][] dir1 = {{0}, {1}, {2}, {3}}; // 1번 CCTV가 한 번에 감시할 수 있는 방향
    private static final int[][] dir2 = {{0, 2}, {1, 3}}; // 2번 CCTV가 한 번에 감시할 수 있는 방향
    private static final int[][] dir3 = {{3, 0}, {0, 1}, {1, 2}, {2, 3}}; // 3번 CCTV가 한 번에 감시할 수 있는 방향
    private static final int[][] dir4 = {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}; // 4번 CCTV가 한 번에 감시할 수 있는 방향
    private static final int[][] dir5 = {{0, 1, 2, 3}}; // 5번 CCTV가 한 번에 감시할 수 있는 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        office = new int[n][m];
        camera = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] != 0 && office[i][j] != 6) {
                    camera.add(new CCTV(i, j, office[i][j])); // 카메라 번호 저장
                }
            }
        }

        resMin = Integer.MAX_VALUE;
        cameraDir = new int[camera.size()]; // 카메라 순열 배열 생성
        permCamera(0);
        System.out.println(resMin);
    }

    private static void permCamera(int idx) {
        if (idx == camera.size()) {
//            System.out.println(Arrays.toString(camera));
            // 배열 복사
            copyOffice = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copyOffice[i][j] = office[i][j];
                }
            }
//            print(copyOffice);

            // 카메라 감시 시작
            for (int i = 0; i < camera.size(); i++) {
                bfsCctv(camera.get(i), cameraDir[i]);
            }

            // 사각 지대 확인
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyOffice[i][j] == 0) {
                        cnt++;
                    }
                }
            }
//            print(copyOffice);
//            System.out.println(cnt);

            // 사각 지대 최소값 갱신
            if (resMin > cnt) {
                resMin = cnt;
            }
            return;
        }

        if (camera.get(idx).number == 1 || camera.get(idx).number == 3 || camera.get(idx).number == 4) {
            for (int i = 0; i < 4; i++) {
                cameraDir[idx] = i;
                permCamera(idx + 1);
            }
        }
        if (camera.get(idx).number == 2) {
            for (int i = 0; i < 2; i++) {
                cameraDir[idx] = i;
                permCamera(idx + 1);
            }
        }
        if (camera.get(idx).number == 5) {
            for (int i = 0; i < 1; i++) {
                cameraDir[idx] = i;
                permCamera(idx + 1);
            }
        }
    }

    private static void bfsCctv(CCTV cctv, int dir) {
        int[] direction = findDirection(cctv.number, dir);

        for (int d : direction) {
            Queue<CCTV> queue = new ArrayDeque<>();
            queue.offer(cctv);

            while (!queue.isEmpty()) {
                CCTV c = queue.poll();

                int ni = c.i + dx[d];
                int nj = c.j + dy[d];

                if (ni >= 0 && nj >= 0 && ni < n && nj < m && office[ni][nj] != 6) {
                    copyOffice[ni][nj] = c.number;
                    queue.offer(new CCTV(ni, nj, c.number));
                }
            }
        }
    }

    static int[] findDirection(int cctv, int dir) {
        switch (cctv) {
            case 1:
                return dir1[dir];
            case 2:
                return dir2[dir];
            case 3:
                return dir3[dir];
            case 4:
                return dir4[dir];
            case 5:
                return dir5[dir];
        }
        return null;
    }

    static void print(int[][] map) {
        System.out.println("----------------------------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    static class CCTV {
        int i;
        int j;
        int number;

        public CCTV(int i, int j, int number) {
            this.i = i;
            this.j = j;
            this.number = number;
        }
    }
}