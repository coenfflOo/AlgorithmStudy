import java.util.*;
import java.io.*;
public class bj10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] balls = new int[N];
        for (int i = 0; i < N; i++) {
            balls[i] = (i+1);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken())-1;
            int b = Integer.parseInt(st2.nextToken())-1;
            int temp = 0;

            temp = balls[a];
            balls[a] = balls[b];
            balls[b] = temp;
        }

        for (int ball: balls) {
            bw.write(ball+" ");
        }
        bw.flush();
    }
}
