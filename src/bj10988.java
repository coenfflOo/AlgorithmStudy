import java.util.*;
import java.io.*;
public class bj10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int result = 1;
        int j = s.length()-1;
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(j--))
                result = 0;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
