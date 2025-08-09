package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ18116 {
    static int[] root;
    static int[] size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        root = new int[1000001];
        size = new int[1000001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if (c=='I') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                makeSet(a);
                int rc = find(a);
                sb.append(size[rc]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void union(int a, int b) {
        makeSet(a);
        makeSet(b);
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;
        if (size[ra] < size[rb]) {
            int t = ra;
            ra = rb;
            rb = t;
        }
        root[rb] = ra;
        size[ra] += size[rb];
    }

    public static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }

    public static void makeSet(int a) {
        if (root[a]==0){
            root[a] = a;
            size[a] = 1;
        }
    }
}
