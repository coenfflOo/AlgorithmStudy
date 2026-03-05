package java_2026.Mar;
import java.util.*;
import java.io.*;
public class BOJ22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] s_arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            s_arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] d_arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            d_arr[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int num = s_arr[i];
            int idx = i;
            int time = K;
            while (time-- > 0) {
                idx = d_arr[idx];
            }
            answer[idx] = num;
        }
        for(int ans : answer){
            System.out.print(ans+" ");
        }
    }
}
