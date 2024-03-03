package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ15656 {
    static int n, m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[m];
        perm(0);
        System.out.println(sb.toString());
    }

    private static void perm(int idx) {
        if (idx == m) {
            for (int val : result) {
                sb.append(val).append(" ");
            }

            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            result[idx] = arr[i];
            perm(idx + 1);
        }
    }
}
