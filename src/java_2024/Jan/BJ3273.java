package java_2024.Jan;
import java.util.*;
import java.io.*;
// 두 수의 합
public class BJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine()); // 합
        int count = 0;
        int l = 0;
        int r = n-1;
        while (l != r){
            if (arr[l]+arr[r] == x) {
                r--;
                count++;
            }
            else {
                if (arr[l]+arr[r] < x)
                    l++;
                else
                    r--;
            }
        }
        System.out.println(count);
    }
}
