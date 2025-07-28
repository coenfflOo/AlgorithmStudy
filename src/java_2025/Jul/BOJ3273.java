package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = n-1;
        int cnt = 0;
        while (start != end) {
            if (end < start) break;
            int sum = arr[start] + arr[end];
            if (sum == x) {
                cnt++;
                start++;
                end--;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(cnt);
    }
}
