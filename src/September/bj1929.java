package September;

import java.util.*;
import java.io.*;

public class bj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[N+1];
        for (int i = 2; i <= N; i++) {
            if (!check[i] &&i>=M)
                sb.append(i).append(" ");
            for (int j = i*2; j <= N; j += i) {
                check[j] = true;
            }
        }
        for (String s :
                sb.toString().split(" ")) {
            bw.write(s+"\n");
        }
        bw.close();
    }
}
