package java_2025.Feb;
import java.util.*;
import java.io.*;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] up = new int[n];
        up[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    up[i] = Math.max(up[i], up[j]+1);
                }
            }
            if (up[i] == 0) {
                up[i] = 1;
            }
        }

        int[] down = new int[n];
        down[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    down[i] = Math.max(down[i], down[j]+1);
                }
            }
            if (down[i] == 0) {
                down[i] = 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, up[i]+down[i]-1);
        }
        System.out.println(max);
    }
}
