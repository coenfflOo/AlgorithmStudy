package java_2025.Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15659_2 {
    private static int[] arr, operation;
    private static int n, max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        calculation(1,0,arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void calculation(int idx, int sum, int prev) {
        if (idx == n) {
            max = Math.max(max, sum+prev);
            min = Math.min(min, sum+prev);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i]>0){
                operation[i]--;
                if (i==0){
                    calculation(idx+1,sum+prev,arr[idx]);
                } else if (i==1){
                    calculation(idx+1,sum+prev,-arr[idx]);
                } else if (i==2){
                    calculation(idx+1,sum,prev*arr[idx]);
                } else{
                    calculation(idx+1,sum,prev/arr[idx]);
                }
                operation[i]++;
            }
        }
    }
}
