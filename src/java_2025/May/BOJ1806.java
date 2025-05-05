package java_2025.May;
import java.util.*;
import java.io.*;
public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 1;
        int ans = Integer.MAX_VALUE;
        while (right<n+1){
            int cur = sum[right] - sum[left];
            if (cur>=s){
                ans = Math.min(ans, right-left);
                if(left+1<right) left++;
                else right++;
                if (right==n+1&&left!= n){
                    left++;
                    right = left+1;
                }
            } else {
                right++;
            }
        }
        if (ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}
