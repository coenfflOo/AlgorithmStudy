package java_2025.Aug;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int avg = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                avg += arr[i];
            }
            avg /= n;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > avg) {
                    cnt++;
                }
            }
            sb.append(String.format("%.3f",(double)(cnt * 100) /n)).append("%\n");
        }
        System.out.println(sb);
    }
}
