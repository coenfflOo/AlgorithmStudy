package java_2024.Jan;

import java.util.Scanner;

public class SWEA1210_2 {
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
            int go = 0;
            while (true) {
                if (endX == 1) {
                    System.out.println(endY - 1);
                    break;
                } else if (game[endX][endY + 1] == 1 && go != 2) {
                    endY++;
                    go = 1;
                } else if (game[endX][endY - 1] == 1 && go != 1) {
                    endY--;
                    go = 2;
                } else if (game[endX - 1][endY] == 1) {
                    endX--;
                    go = 0;
                }
            }
        }
    }
}

