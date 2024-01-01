import java.io.*;
import java.util.StringTokenizer;

public class bj11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String[] str = new String[T];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            str[i] = "Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B)+"\n";
        }

        for (String s: str) {
            bw.write(s);
        }
        bw.flush();
    }
}