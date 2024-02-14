package java_2024.Jan;

import java.util.Scanner;

public class SWEA1210 {
    static int[][] game = new int[102][102];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int test_case = sc.nextInt();
            int endX = 0;
            int endY = 0;
            for (int j = 1; j < 101; j++) {
                for (int j2 = 1; j2 < 101; j2++) {
                    game[j][j2] = sc.nextInt();
                    if (game[j][j2] == 2) {
                        endX = j;
                        endY = j2;
                    }
                }
            }
            System.out.print("#" + test_case + " ");
            findStart(endX, endY, 0);
        }
    }

    private static void findStart(int x, int y, int go) {
        if (x == 1) {
            System.out.println(y - 1);
        } else if (game[x][y + 1] == 1 && go != 2) {
            findStart(x, y + 1, 1);
        } else if (game[x][y - 1] == 1 && go != 1) {
            findStart(x, y - 1, 2);
        } else if (game[x - 1][y] == 1) {
            findStart(x - 1, y, 0);
        }
    }
}

