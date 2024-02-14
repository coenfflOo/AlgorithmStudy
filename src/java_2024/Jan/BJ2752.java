package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for (int i = 0; i < 3; i++) {
            bw.write(String.valueOf(a[i])+" ");
        }
        bw.flush();
    }
}
