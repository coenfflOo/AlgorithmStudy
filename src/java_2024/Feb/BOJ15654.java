package java_2024.Feb;

import java.util.*;
import java.io.*;

public class BOJ15654 {
    static int n, m;
    static int[] arr;
    static int[] result;
    static boolean[] used;

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
        used = new boolean[n];
        permArr(0);
    }

    private static void permArr(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                result[cnt] = arr[i];
                used[i] = true;
                permArr(cnt + 1);
                used[i] = false;
            }
        }
    }
}
