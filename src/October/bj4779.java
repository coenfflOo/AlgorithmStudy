package October;
import java.util.*;
import java.io.*;
public class bj4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        StringBuilder answer = new StringBuilder();
        // while((input = br.readLine()) != null)
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            // NumberFormatException과 NullPointerException 방지
            int N = Integer.parseInt(input);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.pow(3,N); i++) {
                sb.append("-");
            }
            answer.append(Cantor(sb.toString())+"\n");
        }

        bw.write(answer.toString());
        bw.flush();
    }

    private static String Cantor(String s) {
        if (s.length() == 1)
            return "-";
        else {
            long n = s.length() / 3;
            StringBuilder sb = new StringBuilder();
            StringBuilder jump = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append("-");
                jump.append(" ");
            }
            return Cantor(sb.toString()) + jump + Cantor(sb.toString());
        }

    }
}
// ---------         ---------
// ---   ---         ---   ---
// - -   - -         - -   - -