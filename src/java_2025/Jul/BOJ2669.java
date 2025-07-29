package java_2025.Jul;
import java.util.*;
import java.io.*;
import java.lang.*;
public class BOJ2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] square = new boolean[101][101];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int j = a; j < c; j++) {
                for (int k = b; k < d; k++) {
                    square[j][k] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (square[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
