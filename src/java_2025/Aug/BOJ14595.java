package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ14595 {
    static int[] rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        rooms = new int[n+1];
        for (int i = 1; i <= n; i++) rooms[i] = i;
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = find(a);
            int y = find(b);
            while (x<y){
                union(x,x+1);
                x = find(x+1);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(rooms[i] == i) cnt++;
        }
        System.out.println(cnt);
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa != bb) rooms[aa] = bb;
    }

    static int find(int a) {
        if (rooms[a] == a) return a;
        return rooms[a] = find(rooms[a]);
    }
}
