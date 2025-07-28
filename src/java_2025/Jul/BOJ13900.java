package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ13900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        arr[0] = Long.parseLong(st.nextToken());
        for(int i=1; i<n; i++){
            arr[i] = arr[i-1]+Long.parseLong(st.nextToken());
        }
        long sum = 0;
        for(int i=1; i<n; i++){
            sum += arr[i-1]*(arr[i]-arr[i-1]);
        }
        System.out.println(sum);
    }
}
