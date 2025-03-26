package java_2025.Mar;
import java.util.*;
import java.io.*;
public class BOJ21758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n];
        arr[0] = input[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + input[i];
        }

        int max = 0;
        for (int i = 1; i < n-1; i++) {
            int left = arr[n-1]-arr[i]+arr[i-1]-arr[0];
            int right = arr[n-1]-arr[i];
            max = Math.max(max,left+right);
        }

        int[] arr2 = new int[n];
        arr2[n-1] = input[n-1];
        for (int i = n-2; i >= 0; i--) {
            arr2[i] = arr2[i+1]+input[i];
        }

        for (int i = 1; i < n-1; i++) {
            int left = arr2[0]-arr2[i];
            int right = arr2[0]-arr2[i]+arr2[i+1]-arr2[n-1];
            max = Math.max(max,left+right);
        }

        for (int i = 1; i < n-1; i++) {
            int left = arr[i]-arr[0];
            int right = arr2[i]-arr2[n-1];
            max = Math.max(max,left+right);
        }

        System.out.println(max);
    }
}
