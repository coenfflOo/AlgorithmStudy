package java_2024.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int n, k;
    static int[][] board;
    static int dir;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        board = new int[n][n];

        StringTokenizer st;
        board[0][0] = 5;
        Snake head = new Snake(0, 0);
        Snake tail = new Snake(0, 0);
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            board[row][col] = 1;
        }

//		print();

        int l = Integer.parseInt(br.readLine());
        HashMap<Integer, String> change = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int sec = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            change.put(sec, direction);
        }

        dir = 1;
        int time = 0;

        // 반복(true){
        // 1. 시간재기
        // 2. 뱀 이동하기
        // 3. 범위를 벗어나거나, 뱀 몸통 만날 때 종료
        // 4. 사과가 있을 때 없을 때 처리
        // 5. 방향을 바꿔주는 시간을 만날 때 방향 변경
        // 6. 현재값 업데이트
        // }

        Queue<Snake> turnPoint = new ArrayDeque<>();
        int exDir = dir;
        while (true) {
            time++;

            int ni = head.i + dx[dir];
            int nj = head.j + dy[dir];

            if (ni < 0 || nj < 0 || ni >= n || nj >= n || board[ni][nj] == 5) {
                break;
            }

            if (board[ni][nj] != 1) {
                if (!turnPoint.isEmpty()) {
                    Snake s = turnPoint.peek();
                    if (tail.i == s.i && tail.j == s.j) {
                        exDir = s.dir;
                        turnPoint.poll();
                    }
                }
                board[tail.i][tail.j] = 0;
                tail.i += dx[exDir];
                tail.j += dy[exDir];
            }

            board[ni][nj] = 5;
            head.i = ni;
            head.j = nj;

            if (change.containsKey(time)) {
                switch (change.get(time)) {
                    case "L":
                        dir = dir - 1;
                        if (dir == -1)
                            dir = 3;
                        break;
                    case "D":
                        dir = (dir + 1) % 4;
                        break;
                }

                turnPoint.offer(new Snake(ni, nj, dir));
            }
//			print();
        }

        System.out.println(time);
    }

    static class Snake {
        int i;
        int j;
        int dir;

        public Snake(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Snake(int i, int j, int dir) {
            super();
            this.i = i;
            this.j = j;
            this.dir = dir;
        }

    }

    static void print() {
        System.out.println("============================");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
