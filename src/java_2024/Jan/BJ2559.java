package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++){
            sum += arr[i];
        }

        int max = sum;
        for (int i = K; i < N; i++){
            sum += arr[i];
            sum -= arr[i - K];
            max = Math.max(max, sum);
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
