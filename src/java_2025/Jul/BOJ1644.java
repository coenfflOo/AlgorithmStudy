package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;

import static java.lang.System.exit;

public class BOJ1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println("0");
            exit(0);
        }
        boolean[] prime = new boolean[n+1];
        prime[0] = false;
        prime[1] = false;
        for(int i=2; i<= Math.sqrt(n); i++){
            if (prime[i]) continue;
            for(int j = i*i; j<=n; j+=i){
                prime[j] = true;
            }
        }
//        System.out.println(Arrays.toString(prime));
        int[] arr = new int[n];
        int index = 1;
        for(int i=2; i<=n;i++){
            if(!prime[i]){
                arr[index] = arr[index-1] + i;
                index++;
            }
        }
//        System.out.println(Arrays.toString(arr));

        int cnt = 0;
        int start = 0;
        int end = 1;
        while(start < n && start < end){
            int sum = arr[end] - arr[start];
            if (sum > n) {
                start++;
            } else if (sum < n) {
                end++;
            } else {
                cnt++;
                start++;
            }
            if (end == n || arr[end] == 0) {
                start++;
                end -= 1;
            }
        }
        System.out.println(cnt);
    }
}
