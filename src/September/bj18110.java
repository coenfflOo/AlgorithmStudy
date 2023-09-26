package September;
import java.util.*;
import java.io.*;
public class bj18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score);

        int index = (int)Math.round((N*0.15));
        int sum = 0;
        int count = 0;
        for (int i = index; i < N-index; i++) {
            sum += score[i];
            count++;
        }

        System.out.println(Math.round((float) sum /count));
    }
}
