package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long best = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0, ans3 = 0;
        for (int i = 0; i < n-2; i++) {
            int left = i+1, right = n-1;
            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum)<best) {
                    best = Math.abs(sum);
                    ans1 = arr[i];
                    ans2 = arr[left];
                    ans3 = arr[right];
                }
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    System.out.println(ans1 + " " + ans2 + " " + ans3);
                    return;
                }
            }
        }
        System.out.println(ans1+" "+ans2+" "+ans3);
    }
}
