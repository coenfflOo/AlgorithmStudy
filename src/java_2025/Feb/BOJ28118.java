package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ28118 {
    private static int[] building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        building = new int[n+1];
        for (int i = 0; i <= n; i++) {
            building[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        int ans = 0;
        int target = find(1);
        for (int i = 2; i < n+1; i++) {
            if (find(i) != target) {
                union(i,1);
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x==y) return;
        if (x<y) building[y] = x;
        else building[x] = y;
    }

    private static int find(int x){
        if (building[x]==x) return x;
        else return building[x] = find(building[x]);
    }
}
