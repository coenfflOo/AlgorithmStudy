package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long  start = 1;
        long  end = arr[n-1];
        while (start <= end) {
            long  mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt>=m){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(end);
    }
}
