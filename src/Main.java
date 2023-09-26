import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        long e = Integer.parseInt(st.nextToken());
        long f = Integer.parseInt(st.nextToken());
        long x = (c*e-f*b)/(a*e - b*d);
        long y = (c*d-f*a)/(b*d - a*e);


        bw.write(String.valueOf(x)+" "+String.valueOf(y));
        bw.flush();
    }
}
