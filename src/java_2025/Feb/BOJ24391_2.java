package java_2025.Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24391_2 {
    private static int[] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        room = new int[n+1];
        set(n);
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (find(prev) != find(cur)) {
                cnt++;
            }
            prev = cur;
        }
        System.out.println(cnt);
    }

    private static void set(int n) {
        for (int i = 0; i < n + 1; i++) {
            room[i] = i;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (room[a]<room[b]) room[b] = a;
        else room[a]=b;
    }

    private static int find(int a) {
        if (room[a] == a) return a;
        else return room[a] = find(room[a]);
    }
}
