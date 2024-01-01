package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine()); // M 이상
        int N = Integer.parseInt(br.readLine()); // N 이하
        int m = (int) Math.ceil(Math.sqrt(M));
        int n = (int) Math.floor(Math.sqrt(N));
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += i * i;
        }
        if (sum == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(sum));
            bw.newLine();
            bw.write(String.valueOf(m * m));
        }
        bw.flush();
    }
}
