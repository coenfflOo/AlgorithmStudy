import java.util.*;
import java.io.*;
public class bj3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ch = {1, 1, 2, 2, 2, 8};

        int[] current = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < current.length; i++) {
            current[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < current.length; i++) {
            bw.write(String.valueOf(ch[i]-current[i])+" ");
        }
        bw.flush();
    }
}
