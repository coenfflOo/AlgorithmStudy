import java.util.*;
import java.io.*;

public class bj2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int R = ((int) Math.pow(2, N)) + 1;
        bw.write(String.valueOf((int) Math.pow(R, 2)));
        bw.flush();
    }
}
// 4 9 25
//  5 16

// 1-4 1-2 0
// 4-9 2-3 1
// 16-25 4-5 2
// 64-81 8-9 3