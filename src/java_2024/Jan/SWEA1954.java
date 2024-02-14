package java_2024.Jan;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1954 {
    static int[][] arr;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
//    static int number = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            arr = new int[N][N];
            System.out.println("#" + test_case);
            snailNumberIterate(N);
//            snailNumberPerm(n);
        }
    }

    private static void snailNumberPerm(int n) {
        if (checkNumber()){
            for (int[] ints : arr) {
                for (int j = 0; j < n; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
        }


    }

    private static boolean checkNumber() {
        for (int[] nums : arr) {
            if (Arrays.stream(nums).anyMatch(a->a==0))
                return false;
        }
        return true;
    }

    private static void snailNumberIterate(int N) {
        int r = 0, c=0;
        int dir = 0;
        for (int i = 1; i <= N * N; i++) {
            arr[r][c] = i;
            if (r + dx[dir] >= N || r + dx[dir] < 0 || c + dy[dir] >= N || c + dy[dir] < 0
                    || arr[r + dx[dir]][c + dy[dir]] != 0) {
                dir = (dir + 1) % 4;
            }
            r += dx[dir];
            c += dy[dir];
        }
        for (int i = 0; i < N; i++) {
            for (int n : arr[i])
                System.out.print(n + " ");
            System.out.println();
        }
    }
}
// 0.0 0.1 0.2 0.3
// 1.0 1.1 1.2 1.3
// 2.0 2.1 2.2 2.3
// 3.0 3.1 3.2 3.3

// 2-3 3-5 4-7