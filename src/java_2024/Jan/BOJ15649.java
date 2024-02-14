package java_2024.Jan;

import java.util.Scanner;

public class BOJ15649 {
    static int N;
    static int M;
    static boolean[] used;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        used = new boolean[N];
        arr = new int[M];

        findNumber(0);
    }

    private static void findNumber(int idx) {
        if (idx == M) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                arr[idx] = i + 1;
                used[i] = true;
                findNumber(idx + 1);
                used[i] = false;
            }
        }
    }
}