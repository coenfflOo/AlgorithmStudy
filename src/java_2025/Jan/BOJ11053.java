package java_2025.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] len = new int[n];
        len[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j]<arr[i]){
                    if(max<len[j]){
                        max = len[j];
                    }
                }
                if(max==1&&arr[j]<arr[i]){
                    len[i]=max+1;
                }
            }
            len[i] = Math.max(max+1, len[i]);
        }

        int length = 0;
        for(int num: len){
            if(length<num)
                length = num;
        }
        System.out.println(length);
    }
}
