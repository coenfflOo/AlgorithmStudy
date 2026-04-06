package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ34183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int need = N*3-M;
        if (need <= 0) System.out.println("0");
        else {
            System.out.println(need*A+B);
        }
    }
}
