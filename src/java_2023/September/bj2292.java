import java.util.*;
import java.io.*;

public class bj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()) - 1;
        int count = 0;
        if (N == 0)
            count = 1;
        else {
            while (N > 0) {
                N = N - (6 * count);
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
// 1 7 19 37 61
// 1 6 12 18 24
// 1 6