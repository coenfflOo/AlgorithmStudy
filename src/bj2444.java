import java.util.*;
import java.io.*;
public class bj2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = N-i-2; j >= 0; j--) {
                bw.write(" ");
            }
            for (int j = 0; j < (i*2+1); j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = N-1; i >= 1; i--) {
            for (int j = 1; j < N-i+1; j++) {
                bw.write(" ");
            }
            for (int j = ((i-1)*2); j >= 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
// 별찍기 문제 나중에 전체적으로 다시 한번 다 풀어보기