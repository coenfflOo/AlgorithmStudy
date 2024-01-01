import java.util.*;
import java.io.*;
public class bj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            String r = "";
            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    r += S.charAt(j);
                }
                str[i] = r;
            }
        }

        for (String s :
                str) {
            bw.write(s+"\n");
        }
        bw.flush();
    }
}
