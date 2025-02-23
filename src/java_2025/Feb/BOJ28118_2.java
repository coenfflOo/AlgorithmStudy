package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ28118_2 {
    private static int[] pillar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        pillar = new int[n+1];
        set();

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (find(i) != find(1)) {
                cnt++;
                union(1,i);
            }
        }
        System.out.println(cnt);
    }

    private static void set() {
        for (int i = 0; i < pillar.length; i++) {
            pillar[i] = i;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        if (a < b) pillar[b] = a;
        else pillar[a] = b;
    }

    private static int find(int a) {
        if (a == pillar[a]) return a;
        return pillar[a] = find(pillar[a]);
    }
}
