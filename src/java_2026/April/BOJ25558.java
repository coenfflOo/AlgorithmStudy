package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ25558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        long dir = Long.MAX_VALUE;
        int nv=0;
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int curx = sx;
            int cury = sy;
            long sum = 0;
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                sum += Math.abs((long)x - curx) + Math.abs((long)y - cury);
                curx = x;
                cury = y;
            }
            sum += Math.abs((long)ex - curx) + Math.abs((long)ey - cury);
            if (sum < dir){
                dir = sum;
                nv = i+1;
            }
        }
        System.out.println(nv);
    }
}
