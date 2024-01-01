package java_2023.October;

import java.util.*;
import java.io.*;

public class bj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] prefix_sum = new int[N+1];
        for (int i = 1; i <= N; i++) {
            prefix_sum[i] = prefix_sum[i-1]+Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st3.nextToken());
            int j = Integer.parseInt(st3.nextToken());
            sb.append(prefix_sum[j]-prefix_sum[i-1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
