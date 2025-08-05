package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ4195 {
    static int[] root, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int f = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            root = new int[f*2];
            size = new int[f*2];
            for (int i = 0; i < f*2; i++) root[i] = Integer.MAX_VALUE;
            for (int i = 0; i < f; i++) {
                String[] str = br.readLine().split(" ");
                boolean flag1 = false, flag2 = false;
                if (!map.containsKey(str[0])) flag1 = true;
                if (!map.containsKey(str[1])) flag2 = true;
                map.put(str[0], map.getOrDefault(str[0], map.size()));
                map.put(str[1], map.getOrDefault(str[1], map.size()));
                int a = map.get(str[0]);
                int b = map.get(str[1]);
                if (root[a] == Integer.MAX_VALUE) root[a] = a;
                if (root[b] == Integer.MAX_VALUE) root[b] = b;
                if (flag1) size[a] =1;
                if (flag2) size[b] =1;
                sb.append(union(a,b)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if (aa != bb) {
            root[bb] = aa;
            size[aa] += size[bb];
        }
        return size[find(aa)];
    }

    static int find(int a) {
        if (root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
