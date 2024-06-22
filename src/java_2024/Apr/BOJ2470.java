package java_2024.Apr;

import java.util.*;
import java.io.*;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);

        int left = 0;
        int right = n - 1;
        int res = Integer.MAX_VALUE;
        int l1 = 0, l2 = 0;
        while (left < right) {
            int v = liquid[left] + liquid[right];
            int value = Math.abs(v);
            if (value < res) {
                res = value;
                l1 = liquid[left];
                l2 = liquid[right];
            }

            if (v < 0) {
                left++;
            } else if (v > 0) {
                right--;
            } else {
                l1 = liquid[left];
                l2 = liquid[right];
                break;
            }
        }
        bw.write(l1 + " " + l2);
        bw.flush();
    }
}
