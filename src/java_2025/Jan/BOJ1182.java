package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1182 {
    private static int n,s,cnt;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        subset(0,0,0);
        System.out.println(cnt);
    }

    private static void subset(int index, int sum, int select){
        if(index== n){
            if(select ==0) return;
            if(sum == s)
                cnt++;
            return;
        }

        subset(index+1, sum, select);
        subset(index+1, sum+arr[index], select+1);
    }
}
