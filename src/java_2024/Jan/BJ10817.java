package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[3];
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);
        bw.write(String.valueOf(number[1]));
        bw.flush();
    }
}
