import java.util.*;
import java.io.*;
public class bj2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        String nA = "";
        String nB = "";
        for (int i = 2; i >= 0 ; i--) {
            nA += A.charAt(i);
            nB += B.charAt(i);
        }

        int numA = Integer.parseInt(nA);
        int numB = Integer.parseInt(nB);

        bw.write(String.valueOf(Math.max(numA,numB)));
        bw.flush();
    }
}
