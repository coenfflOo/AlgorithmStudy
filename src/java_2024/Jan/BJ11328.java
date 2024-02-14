package java_2024.Jan;
import java.util.*;
import java.io.*;
public class BJ11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fir = st.nextToken();
            String sec = st.nextToken();
            String[] str2 = sec.split("");
            for (int j = 0; j < sec.length(); j++) {
                if (fir.contains(str2[j])){
                    fir = fir.replaceFirst(str2[j]," ");
                }
            }
            if (fir.equals(" ".repeat(str2.length)))
                res.append("Possible\n");
            else
                res.append("Impossible\n");
        }
        bw.write(res.toString());
        bw.flush();
    }
}
