package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ9372 {
    static int[] planes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            planes = new int[n+1];
            for (int i = 1; i <= n; i++) planes[i] = i;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (union(a,b)) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if (aa == bb) return false;
        planes[bb] = aa;
        return true;
    }

    public static int find(int a) {
        if(planes[a] == a) return a;
        return planes[a] = find(planes[a]);
    }
}
