package java_2026.Mar;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ1182 {
    static int n,s, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;

        findArr(0,0,0);
        System.out.println(ans);
    }

    public static void findArr(int start, int sum,int select){
        if (sum == s){
            if (select > 0)
                ans++;
        }

        for (int i = start; i < n; i++) {
            findArr(i+1, sum+arr[i], select+1);
        }
    }
}
