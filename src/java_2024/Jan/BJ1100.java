package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ1100 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0 && s.charAt(j) == 'F') {
                    cnt++;
                }
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
    }
}
