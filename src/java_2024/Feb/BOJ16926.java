package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ16926 {
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(st.nextToken()) - 1;
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotateArr();
        }

        print();
    }

    private static void rotateArr() {
        for (int i = 0; i < (Math.min(N, M) + 1) / 2; i++) {
            int temp = arr[i][i];
            for (int j = 0; j < M - 2 * i; j++) {
                arr[i][i + j] = arr[i][i + j + 1];
            }
            for (int j = 0; j < N - 2 * i; j++) {
                arr[i + j][M - i] = arr[i + j + 1][M - i];
            }
            for (int j = 0; j < M - 2 * i; j++) {
                arr[N - i][M - i - j] = arr[N - i][M - i - j - 1];
            }
            for (int j = 0; j < N - 1 - 2 * i; j++) {
                arr[N - i - j][i] = arr[N - i - j - 1][i];
            }
            arr[i + 1][i] = temp;
        }
    }

    private static void print() {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}