package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arrSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    arrSum[i][j] = Integer.parseInt(st.nextToken());
                } else {
                    arrSum[i][j] = arrSum[i][j - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int newy = y1 == 0 ? 0 : y1 - 1;
            int ans = 0;
            if (y1 == 0) {
                for (int j = x1; j <= x2; j++) {
                    ans += arrSum[j][y2];
                }
            } else {
                for (int j = x1; j <= x2; j++) {
                    ans += arrSum[j][y2] - arrSum[j][newy];
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}
