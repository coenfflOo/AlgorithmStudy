package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ24391 {
    private static int n;
    private static int[] building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        building = new int[n+1];
        set();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int study = Integer.parseInt(st.nextToken());
            if (i==0){
                prev = study;
                continue;
            }
            if(find(study) != find(prev))
                cnt++;
            prev = study;
        }
        System.out.println(cnt);
    }

    private static void set(){
        for (int i = 0; i < n+1; i++) {
            building[i]=i;
        }
    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if (x < y) building[y] = x;
            else building[x] = y;
        }
    }

    private static int find(int x){
        if (building[x]==x) return x;
        else return building[x] = find(building[x]);
    }
}
