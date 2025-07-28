package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1;
        int cnt = 0;
        while (start<n+1){
            int sum = arr[end] - arr[start];
            if (sum<m){
                end++;
            } else if (sum>m){
                start++;
            } else {
                cnt++;
                start++;
            }

            if (end == n+1){
                start++;
                end = n;
            }
        }
        System.out.println(cnt);
    }
}
