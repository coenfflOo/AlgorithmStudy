package java_2025.Mar;

import java.util.*;
import java.io.*;

public class BOJ2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] tree = new long[n];
        long low = 0;
        long high = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            high = Math.max(high, tree[i]);
        }

        while (low < high) {
            long mid = (low+high)/2;
            long length = 0;

            for(long t: tree) {
               length += Math.max(0, t-mid);
            }

            if (length >= m) low = mid + 1;
            else high = mid;
        }
        System.out.println(low-1);
    }
}
