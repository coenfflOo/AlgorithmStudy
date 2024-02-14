package java_2024.Jan;
import java.util.*;
import java.io.*;

public class BJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] square = new boolean[100][100];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            for (int j = row; j < row+10; j++) {
                for (int k = col; k < col+10; k++) {
                    square[j][k] = true;
                }
            }
        }

        int res = 0;
        for (boolean[] blacks :
                square) {
            for (boolean black:
                 blacks) {
                if (black)
                    res++;
            }
        }
        System.out.println(res);
    }
}
