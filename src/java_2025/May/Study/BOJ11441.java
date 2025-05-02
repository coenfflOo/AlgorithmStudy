package java_2025.May.Study;
import java.util.*;
import java.io.*;
public class BOJ11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sum = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            sum[i] = Integer.parseInt(st.nextToken())+sum[i-1];
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken());
            System.out.println(sum[b]-sum[a]);
        }
    }
}
