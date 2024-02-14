package java_2024.Jan;

import java.util.*;
import java.io.*;

public class SWEA11315 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] panel = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] dos = sc.next().split("");
                int index = 0;
                for (String dol : dos) {
                    if (dol.equals(".")) {
                        panel[i][index++] = 0;
                    } else {
                        panel[i][index++] = 1;
                    }
                }
            }
            if (checkGame(panel)) {
                System.out.println("#" + test_case + " " + "YES");
            } else {
                System.out.println("#" + test_case + " " + "NO");
            }
        }
    }

    private static boolean checkGame(int[][] panel) {
        for (int i = 0; i + 4 < panel.length; i++) {
            for (int j = 0; j + 4 < panel.length; j++) {
                int[][] game = new int[5][5];
                for (int k = 0; k < 5; k++) {
                    System.arraycopy(panel[i + k], j, game[k], 0, 5);
                }
                if (rowCheck(game) | colCheck(game) | crossCheck(game)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean rowCheck(int[][] panel) {
        for (int[] arr : panel) {
            if (Arrays.stream(arr).sum() == 5) {
                return true;
            }
        }
        return false;
    }

    private static boolean colCheck(int[][] panel) {
        for (int i = 0; i < 5; i++) {
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = panel[j][i];
            }
            if (Arrays.stream(arr).sum() == 5) {
                return true;
            }
        }
        return false;
    }

    private static boolean crossCheck(int[][] panel) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = panel[i][4 - i];
            arr2[i] = panel[i][i];
        }
        return Arrays.stream(arr1).sum() == 5 || Arrays.stream(arr2).sum() == 5;
    }
}

