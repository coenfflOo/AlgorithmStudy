package java_2025.Feb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17352_2 {
    private static int[] bridge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bridge = new int[300_001];
        set();
        StringTokenizer st;
        for (int i = 0; i < n-2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        for (int i = 2; i < n+1; i++) {
            if (find(1) != find(i)) {
                System.out.println(1+" "+i);
                break;
            }
        }
    }

    private static void set() {
        for (int i = 1; i < 300_001; i++) {
            bridge[i] = i;
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        if (a < b) bridge[b] = a;
        else bridge[a] = b;
    }

    private static int find(int a) {
        if (bridge[a] == a) return a;
        return bridge[a] = find(bridge[a]);
    }
}
