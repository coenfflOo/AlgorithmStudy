package September;
import java.util.*;
import java.io.*;
public class bj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                break;
            } else {
                N -= 3;
                count++;
            }
        }
        if (N < 0) {
            count = -1; // N킬로그램을 정확하게 배달할 수 없는 경우 -1 출력
        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
