package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1647 {
    static int[] homes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Road> roads = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roads.add(new Road(a, b, c));
        }
        Collections.sort(roads);
        homes = new int[n];
        for (int i = 0; i < n; i++) homes[i] = i;

        int total = 0;
        int max = 0;
        int cnt = 0;
        for (Road road : roads) {
            if(union(road.a-1, road.b-1)) {
                total += road.c;
                max = Math.max(max, road.c);
                cnt++;
                if(cnt == n-1) break;
            }
        }
        System.out.println(total-max);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if (aa == bb) return false;
        homes[bb] = aa;
        return true;
    }

    static int find(int a) {
        if (homes[a] == a) return a;
        return homes[a] = find(homes[a]);
    }

    static class Road implements Comparable<Road> {
        int a, b, c;
        Road(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Road o) {
            return this.c - o.c;
        }
    }
}
