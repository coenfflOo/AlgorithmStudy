package java_2025.Feb;
import java.util.*;
import java.io.*;
public class BOJ14002_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] len = new int[n];
        int[] idx = new int[n];
        len[0] = 1;
        idx[0] = -1;
        for (int i = 1; i < n; i++) {
            len[i] = 1;
            idx[i] = i;
            for (int j = i-1; j >= 0 ; j--) {
                if(arr[j]<arr[i]){
                    if(len[i]<len[j]+1){
                        len[i] = len[j]+1;
                        idx[i] = j;
                    }
                }
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(max<len[i]){
                max = len[i];
                index = i;
            }
        }
        System.out.println(max);
        int[] answer = new int[max];
        int cnt = max-1;
        while (cnt > -1){
            answer[cnt--] = arr[index];
            index = idx[index];
        }
        for(int num: answer){
            System.out.print(num+" ");
        }
    }
}
