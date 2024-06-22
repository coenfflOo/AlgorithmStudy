package java_2024.June;

import java.util.*;
import java.io.*;

public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        int t = 0;
        while (!(s = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bw.write("Case " + (++t) + ": " + (v / p * l + Math.min(l, v % p)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
