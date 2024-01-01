import java.util.*;
import java.io.*;

public class bj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int a = arr[i];
            for (int j = 1; j < N; j++) {
                int b = arr[j];
                for (int k = 2; k < N; k++) {
                    int c = arr[k];
                    if (i != j && i != k && k != j && (a+b+c)<=M && (a+b+c) > max)
                        max = (a+b+c);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
