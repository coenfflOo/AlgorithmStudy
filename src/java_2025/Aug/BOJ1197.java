package java_2025.Aug;

import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1197 {
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w));
        }
        Collections.sort(edges);

        root = new int[v+1];
        for (int i = 1; i <= v; i++) root[i] = i;
        long total = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.a, edge.b)) {
                total += edge.w;
                cnt++;
                if (cnt == v-1) break;
            }
        }
        System.out.println(total);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if (aa == bb) return false;
        root[bb] = aa;
        return true;
    }

    static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    static class Edge implements Comparable<Edge> {
        int a, b, w;
        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return w - o.w;
        }
    }
}
