package java_2025.Feb;

import static java.lang.System.exit;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17352 {
    private static int n;
    private static int[][] map;
    private static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        root = new int[300_001];
        set();

        for (int i = 0; i < n-2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x,y);
        }

        int parent = find(1);
        for (int i = 1; i <= n; i++) {
            if (parent != find(i)){
                System.out.println(1+" "+i);
                exit(0);
            }
        }

    }

    private static void set(){
        for (int i = 0; i < 300_001; i++) {
            root[i] = i;
        }
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) root[y] = x;
            else root[x] = y;
        }
    }

    private static int find(int x){
        if (root[x]==x)
            return x;
        else return root[x] = find(root[x]);
    }
}
