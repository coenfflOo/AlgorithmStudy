package java_2024.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    static int r;
    static int c;
    static int[][] arr;
    static boolean[] moved;
    static int ans;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j) - 'A';
            }
        }

        ans = 0;
        moved = new boolean[26];

        dfs(0, 0, 0);

        if (r == 1 && c == 1) {
            System.out.println("1");
        }
        else
            System.out.println(ans);
    }

    private static void dfs(int i, int j, int count) {
        if (moved[arr[i][j]]) {
            ans = Math.max(ans, count);
            return;
        }

        moved[arr[i][j]] = true;
        for (int k = 0; k < 4; k++) {
            int newi = i + di[k];
            int newj = j + dj[k];

            if (newi >= 0 && newi < r && newj >= 0 && newj < c ) {
                dfs(newi, newj, count + 1);
            }
        }
        moved[arr[i][j]] = false;
    }
}
