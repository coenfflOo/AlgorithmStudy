package java_2025.Apr;

import java.util.*;
import java.io.*;

public class BOJ3019 {
    private static int[][][] blocks = {
            {{0}, {0, 0, 0, 0}},
            {{0, 0}},
            {{0, 0, 1}, {1, 0}},
            {{1, 0, 0}, {0, 1}},
            {{0, 0, 0}, {0, 1}, {1, 0}, {1, 0, 1}},
            {{0, 0, 0}, {0, 0}, {0, 1, 1}, {2, 0}},
            {{0, 0, 0}, {0, 2}, {1, 1, 0}, {0, 0}}
    };

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
//        int[][] field = new int[105][c];
//        int maxH = 0;
//        for (int i = 0; i < c; i++) {
//            int h = Integer.parseInt(st.nextToken());
//            for (int j = 0; j < h; j++) {
//                field[j][i] = 1;
//            }
//            maxH = Math.max(maxH, h);
//        }
        int[] field = new int[c];
        for (int i = 0; i < c; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }

        int[][] block = blocks[p-1];
        int cnt = 0;
        for (int i = 0; i < block.length; i++) {
            int[] cur = block[i];
            for (int j = 0; j < c-cur.length+1; j++) {
                boolean flag = false;
                for (int k = 0; k < cur.length-1; k++) {
                    if (field[j+k]-cur[k]!=field[j+k+1]-cur[k+1]) flag = true;
                }
                if (!flag) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
