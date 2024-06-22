package java_2024.Apr;

import java.io.*;

public class BOJ9663 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = 0;
        visited = new boolean[n];
        chess(0);
        System.out.println(count);
    }

    private static void chess(int i) {

        if (i == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!visited[j] && checkmate(i, j)) {
                map[i][j] = 1;
                visited[j] = true;
                chess(i + 1);
                map[i][j] = 0;
                visited[j] = false;
            }
        }
    }

    private static boolean checkmate(int i, int j) {
        int l = j;
        for (int k = i; k >= 0; k--) {
            if (l < 0) {
                break;
            }
            if (map[k][l] == 1) {
                return false;
            }
            l--;
        }

        l = j;
        for (int k = i; k >= 0; k--) {
            if (l >= n) {
                break;
            }
            if (map[k][l] == 1) {
                return false;
            }
            l++;
        }
        return true;
    }
}