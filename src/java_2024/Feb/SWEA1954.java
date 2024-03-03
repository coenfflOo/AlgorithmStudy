package java_2024.Feb;

import java.util.*;
import java.io.*;

public class SWEA1954 {
    static int n;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            arr = new int[n][n];

            int dir = 0; // 방향 인덱스
            int r = 0, c = 0;
            for (int i = 1; i <= n * n; i++) {
                arr[r][c] = i;
                if (r + dx[dir] >= n || r + dx[dir] < 0 || c + dy[dir] >= n || c + dy[dir] < 0
                        || arr[r + dx[dir]][c + dy[dir]] != 0) {
                    dir = (dir + 1) % 4; // 방향 바꾸기
                }
                r += dx[dir];
                c += dy[dir];
            }

            System.out.println("#" + test_case);
            print();
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
