package java_2024.May;

import java.util.*;
import java.io.*;

public class BOJ3980 {
    static int[][] player;
    static int[] res;
    static boolean[] selected;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            player = new int[11][11];
            StringTokenizer st;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            res = new int[11];
            selected = new boolean[11];
            playerScore(0);
            System.out.println(max);
        }
    }

    private static void playerScore(int idx) {
        if (idx == 11) {
            int sum = 0;
            for (int i = 0; i < 11; i++) {
                sum += res[i];
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (!selected[i] && player[idx][i] != 0) {
                res[idx] = player[idx][i];
                selected[i] = true;
                playerScore(idx + 1);
                selected[i] = false;
            }
        }
    }

}
