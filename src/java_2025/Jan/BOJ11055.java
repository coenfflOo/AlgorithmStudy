package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        sum[0]=arr[0];
        for(int i=1; i<n; i++){
            int s=0;
            for(int j=0; j<=i-1; j++){
                if(arr[j]<arr[i]&&s<sum[j]){
                    s = sum[j];
                }
            }
            sum[i] = arr[i]+s;
        }

        int max = 0;
        for(int num: sum){
            if(max<num)
                max = num;
        }
        System.out.println(max);

    }
}
