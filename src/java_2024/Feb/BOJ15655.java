package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ15655 {
    static int n, m;
    static int[] arr;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        combArr(0, 0);
    }

    private static void combArr(int cnt, int start) {
        if (cnt == m) {
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (start == n) {
            return;
        }

        used[start] = true;
        combArr(cnt + 1, start + 1);
        used[start] = false;
        combArr(cnt, start + 1);
    }
}
