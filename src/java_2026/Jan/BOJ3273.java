package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[]  arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str[i]);
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int x = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (start < end) {
            int sum = arr[start]+arr[end];
            if (sum==x) {
                start++;
                cnt++;
            } else if (sum>x) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}
