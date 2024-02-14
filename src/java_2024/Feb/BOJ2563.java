package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] square = new boolean[101][101];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            for (int j = row; j < row + 10; j++) {
                for (int k = col; k < col + 10; k++) {
                    square[j][k] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (square[i][j]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
