package java_2024.Feb;
import java.util.*;
import java.io.*;
public class BOJ7569 {
    static int[][][] appleBoxes;
    static int h, n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        appleBoxes = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    appleBoxes[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }


    }
}
