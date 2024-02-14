package java_2024.Jan;

import java.util.*;
// 스도쿠 검증
public class SWEA1974 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }
            if (checkSudoku(sudoku)) {
                System.out.println("#" + test_case + " " + "1");
            } else {
                System.out.println("#" + test_case + " " + "0");
            }
        }
    }

    private static boolean checkSudoku(int[][] sudoku) {
        int row = rowCheck(sudoku);
        int col = colCheck(sudoku);
        int square = squareCheck(sudoku);
        return row + col + square == 3;
    }

    private static int squareCheck(int[][] sudoku) {

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int[] arr = new int[9];
                int index = 0;
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        arr[index++] = sudoku[k][l];
                    }
                }
                if (Arrays.stream(arr).noneMatch(a -> a == 0) && Arrays.stream(arr).sum() != 45) {
                    return 0;
                }
            }

        }
        return 1;
    }

    private static int colCheck(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            int[] arr = new int[9];
            for (int j = 0; j < 9; j++) {
                arr[j] = sudoku[j][i];
            }
            if (Arrays.stream(arr).sum() != 45) {
                return 0;
            }
        }
        return 1;
    }

    private static int rowCheck(int[][] sudoku) {
        for (int[] arr : sudoku) {
            if (Arrays.stream(arr).sum() != 45) {
                return 0;
            }
        }
        return 1;
    }
}
