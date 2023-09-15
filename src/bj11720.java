import java.util.*;
import java.io.*;
public class bj11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String num = br.readLine();
        String[] arr = num.split("");
        int sum=0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
