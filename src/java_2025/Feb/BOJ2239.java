package java_2025.Feb;

import static java.lang.System.exit;

import java.util.*;
import java.io.*;

public class BOJ2239 {
    private static int[][] map;
    private static boolean[][] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        used = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                int number = Integer.parseInt(st[j]);
                map[i][j] = number;
                used[i][number] = true;
            }
        }
        sudoku(0, 0);
    }

    private static void sudoku(int startI, int startJ) {
        if (checkSudoku()) {
            print();
            exit(0);
        }

        for (int i = startI; i < 9; i++) {
            for (int j = startJ; j < 9; j++) {
                if (map[i][j] != 0) {
                    if (j==8) startJ=0;
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (used[i][k]) {
                        continue;
                    }
                    if (checkSquare(i, j, k)) {
                        continue;
                    }
                    if (checkLine(j, k)) {
                        continue;
                    }
                    used[i][k] = true;
                    map[i][j] = k;
                    if (j == 8) {
//                        System.out.println("here");
//                        print();
                        sudoku(i + 1, 0);
                    } else {
//                        print();
                        sudoku(i, j + 1);
                    }
                    used[i][k] = false;
                    map[i][j] = 0;
                }
                if(map[i][j]==0) return;
            }
        }
    }

    private static boolean checkSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j]==0) return false;
            }
        }
        return true;
    }

    private static boolean checkLine(int j, int k) {
        for (int i = 0; i < 9; i++) {
            if (map[i][j] == k) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkSquare(int i, int j, int k) {
        int ii = i;
        int jj = j;
        if (i % 3 == 1) {
            ii -= 1;
        } else if (i % 3 == 2) {
            ii -= 2;
        }
        if (j % 3 == 1) {
            jj -= 1;
        } else if (j % 3 == 2) {
            jj -= 2;
        }
        for (int l = ii; l < ii + 3; l++) {
            for (int m = jj; m < jj + 3; m++) {
                if (map[l][m] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void print() {
        for (int[] m : map) {
//            System.out.println(Arrays.toString(m));
            for(int num: m){
                System.out.print(num);
            }
            System.out.println();
        }
//        System.out.println("=======================");
    }
}
