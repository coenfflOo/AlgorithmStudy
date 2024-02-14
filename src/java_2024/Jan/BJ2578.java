package java_2024.Jan;

import java.util.*;
import java.io.*;

public class BJ2578 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] bingoPanel = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < 5; j++) {
                bingoPanel[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 25; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (bingoPanel[j][k] == num) {
                        bingoPanel[j][k] = 0;
                    }
                    if (checkBingo(bingoPanel)) {
                        System.out.println(i + 1);
                        return;
                    }
                }
            }
        }
    }

    private static boolean checkBingo(int[][] panel) {
        int colBingo = checkColBingo(panel);
        if (colBingo >= 3) {
            return true;
        }
        int rowBingo = checkRowBingo(panel);
        if (rowBingo >= 3) {
            return true;
        }
        int crossBingo = checkCrossBingo(panel);

        return colBingo + rowBingo + crossBingo >= 3;
    }

    private static int checkCrossBingo(int[][] panel) {
        int count = 0;
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        for (int i = 0; i < 5; i++) {
            arr1[i] = panel[i][4-i];
            arr2[i] = panel[i][i];
        }
        if (Arrays.stream(arr1).sum() == 0)
            count++;
        if (Arrays.stream(arr2).sum() == 0)
            count++;
        return count;
    }

    private static int checkRowBingo(int[][] rows) {
        int count = 0;
        for (int[] row: rows) {
            if(Arrays.stream(row).sum() == 0)
                count++;
        }
        return count;
    }

    private static int checkColBingo(int[][] cols) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int[] newArr = new int[5];
            for (int j = 0; j < 5; j++) {
                newArr[j] = cols[j][i];
            }
            if (Arrays.stream(newArr).sum() == 0)
                count++;
        }
        return count;
    }
}