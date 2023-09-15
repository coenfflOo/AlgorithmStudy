import java.util.*;
import java.io.*;
public class bj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] score = new double[N];
        double M = 0;
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            if (score[i]>M)
                M=score[i];
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            double s = score[i];
            score[i] = (s/M)*100;
            sum += score[i];
        }
        bw.write(String.valueOf(sum/N));
        bw.flush();
    }
}
