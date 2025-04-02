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
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long low = 0;
        long high = max;
        while (low < high) {
            long mid = (low+high)/2;
            long length = 0;

            for(long t: tree) {
                if(t-mid>0) length += t-mid;
            }

            if (length >= m) low = mid + 1;
            else high = mid;
        }
        System.out.println(low-1);
    }
}
