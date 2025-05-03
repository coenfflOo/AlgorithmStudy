package java_2025.May;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n-1;
            boolean flag = false;
            while (left < right) {
                if (left==i) {
                    left++;
                    continue;
                } else if (right==i) {
                    right--;
                    continue;
                }
                if (arr[left]+arr[right]==arr[i]) {
                    flag = true;
                    break;
                } else if (arr[left]+arr[right]<arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
