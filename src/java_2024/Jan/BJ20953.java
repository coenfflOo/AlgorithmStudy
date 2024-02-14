package java_2024.Jan;
import java.io.*;
import java.util.StringTokenizer;

public class BJ20953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(dolmen(a, b) + "\n");
        }
        bw.flush();
    }

    public static long dolmen(int a, int b) {
        return (long) (a + b) *(a+b)*(a + b -1)/2;
    }
}
