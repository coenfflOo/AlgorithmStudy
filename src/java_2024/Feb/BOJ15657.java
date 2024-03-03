package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ15657 {
    static int n, m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        used = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[m];
        comb(0, 0);
        System.out.println(sb.toString());
    }

    private static void comb(int cnt, int start) {
        if (cnt == m) {
            for (int val : result) {
                sb.append(val).append(" ");
            }

            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            result[cnt] = arr[i];
            comb(cnt + 1, i);
        }
    }
}
