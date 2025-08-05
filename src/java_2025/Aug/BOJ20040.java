package java_2025.Aug;

import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ20040 {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) == find(b)) {
                System.out.println(i+1);
                return;
            }
            union(a,b);
        }
        System.out.println("0");
    }

    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB){
            root[rootB] = rootA;
        }
    }

    static int find(int n){
        if(root[n] != n) root[n] = find(root[n]);
        return root[n];
    }
}