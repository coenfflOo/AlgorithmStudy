package java_2025.Mar;
import java.util.*;
import java.io.*;
public class BOJ14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] item = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.MAX_VALUE;
                if (i==j){
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int l = Integer.parseInt(st.nextToken());
            map[a][b] = l;
            map[b][a] = l;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][k]!=Integer.MAX_VALUE&&map[k][j]!=Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == Integer.MAX_VALUE){
                    map[i][j] = m+20;
                }
            }
        }

        int getItems = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= m) {
                    current += item[j];
                }
            }
            getItems = Math.max(getItems, current);
        }
        System.out.println(getItems);
    }
}
