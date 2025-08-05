package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ7511 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            sb.append("Scenario ").append(i+1).append(":\n");
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            parent = new int[n];
            for (int j = 0; j < n; j++) parent[j] = j;

            StringTokenizer st;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }

            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (find(a) == find(b)) sb.append("1\n");
                else sb.append("0\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
