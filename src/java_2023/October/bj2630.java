package java_2023.October;

import java.util.*;
import java.io.*;

public class bj2630 {

    public static int white = 0;
    public static int blue = 0;
    public static int[][] square;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,N);

        bw.write(String.valueOf(white));
        bw.newLine();
        bw.write(String.valueOf(blue));
        bw.flush();
    }

    private static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)){
            if (square[row][col]==0)
                white++;
            else
                blue++;
        }
        else {

            int newSize = size / 2;

            partition(row, col, newSize);                        // 2사분면
            partition(row, col + newSize, newSize);                // 1사분면
            partition(row + newSize, col, newSize);                // 3사분면
            partition(row + newSize, col + newSize, newSize);    // 4사분면
        }
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = square[row][col];

        for (int i = row; i < row+size; i++) {
            for (int j = col; j < col+size; j++) {
                if (square[i][j] != color)
                    return false;
            }
        }
        return true;
    }
}
