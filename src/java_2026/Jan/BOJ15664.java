package java_2026.Jan;
import java.util.*;
import java.io.*;
public class BOJ15664 {
    static int N,M;
    static int[] arr, number;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        number = new int[M];
        findNumber(0,0);
        System.out.println(sb);
    }

    private static void findNumber(int start, int select) {
        if (select == M) {
            for(int num:number){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = start; i < N; i++) {
            if (prev == arr[i]) continue;
            prev = arr[i];
            number[select] = arr[i];
            findNumber(i+1, select+1);
        }
    }
}
