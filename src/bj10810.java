import java.io.*;
import java.util.StringTokenizer;

public class bj10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] balls = new int[N];
        for (int i = 0; i < N; i++) {
            balls[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            for (int j = a-1; j <= b-1; j++) {
                    balls[j] = c;
            }
        }

        for (int ball: balls) {
            bw.write(ball+" ");
        }
        bw.flush();
    }
}
