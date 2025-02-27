package java_2025.Feb;
import java.io.*;
import java.util.*;
public class BOJ11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] load = new int[n][n];
        int INF = 100000*n+1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j)
                    continue;
                load[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            load[a][b] = Math.min(load[a][b],c);
        }

        for(int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    load[i][j] = Math.min(load[i][j], load[i][k]+load[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(load[i][j] == INF)
                    load[i][j] = 0;
            }
        }

        for(int[] l: load) {
            for(int answer: l) {
                System.out.print(answer + " ");
            }
            System.out.println();
        }
    }
}
