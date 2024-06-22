package java_2024.May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5653_줄기세포배양 {
    static class Cell {
        int row, col, state, cnt;

        Cell(int row, int col, int cnt, int state) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.state = state; // 0 = 비활, 1 = 활성, 2 = 죽음
        }

        @Override
        public String toString() {
            return "Cell [row=" + row + ", col=" + col + ", state=" + state + ", cnt=" + cnt + "]";
        }
    }

    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    static int[][] arr;
    static int n, m, k, ans;
    static boolean[][] visit;
    static Queue<Cell> q;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test = 1; test <= t; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n + k + 2][m + k + 2];
            visit = new boolean[n + k + 2][m + k + 2];

            q = new LinkedList<>();
            ans = 0;

            int temp;
            for (int i = k / 2 + 1; i < n + k / 2 + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = k / 2 + 1; j < m + k / 2 + 1; j++) {
                    temp = Integer.parseInt(st.nextToken());
                    if (temp != 0) {
                        arr[i][j] = temp;
                        visit[i][j] = true;
                        q.add(new Cell(i, j, temp,0));
                    }
                }
            }

//            for(int i = 0; i <n+k; i++) {
//                for(int j = 0; j <m+k; j++) {
//                    System.out.print(arr[i][j]+" ");
//                }
//                System.out.println();
//            }
            bfs();

            System.out.println("#"+test+" "+q.size());
        }
    }

    static void bfs() { // 확산
        int time = 0;
        while (!q.isEmpty()) {
            if (time == k) {
                return;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell cur = q.poll();
                if (cur.state == 1) { // 활성 상태 일 때만 번식
                    for (int d = 0; d < 4; d++) {
                        int newi = cur.row + di[d];
                        int newj = cur.col + dj[d];

                        if (!visit[newi][newj] && arr[newi][newj] == 0) {
                            q.offer(new Cell(newi, newj, cur.cnt, 0));
                            arr[newi][newj] = cur.cnt;
                            visit[newi][newj] = true;
                        }
                    }
                }
                // 세포 상태 체크
                if(cur.cnt == 1 && cur.state == 1) { //활성 상태고 남은 생명이 1이면 이제 죽음
                    arr[cur.row][cur.col] = 0;
                    continue;
                }
                else if(cur.cnt >= 1 && cur.state == 0) { //비활성 상태면 활성으로 바꿔줌
                    q.offer(new Cell(cur.row, cur.col, cur.cnt, 1));
                }
                else if(cur.cnt > 1 && cur.state == 1){ //활성 상태 였다면 숫자 감소
                    arr[cur.row][cur.col] -=1;
                    q.offer(new Cell(cur.row,cur.col,cur.cnt-1,1));
                }
            }
            time += 1;
        }
    }

}